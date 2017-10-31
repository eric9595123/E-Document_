/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 個人亮燈頻率 & 異常回覆 (For IE)
 */
package com.advantech.servlet;

import com.advantech.helper.DatetimeGenerator;
import com.advantech.helper.ExcelGenerator;
import com.advantech.helper.UserSelectFilter;
import com.advantech.service.BABService;
import com.advantech.service.CountermeasureService;
import java.io.*;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.joda.time.DateTime;
import org.joda.time.Seconds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Wei.Cheng
 */
@Controller
public class BABExcelGenerate {

    private final int minAllowAmount = 10;

    @Autowired
    private CountermeasureService cService;
    
    @Autowired
    private BABService babService;

    private String lineType, sitefloor;

    @RequestMapping(value = "/BABExcelGenerate", method = {RequestMethod.GET})
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        DateTime startTime = new DateTime();

//http://stackoverflow.com/questions/13853300/jquery-file-download-filedownload
//personalAlm記得轉格式才能special Excel generate
        lineType = req.getParameter("lineType");
        sitefloor = req.getParameter("sitefloor");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String aboveStandard = req.getParameter("aboveStandard");

        List<Map> countermeasures = fitData(cService.getCountermeasureForExcel(startDate, endDate));
        List<Map> personalAlarms = fitData(cService.getPersonalAlmForExcel(startDate, endDate));
        List<Map> emptyRecords = fitData(babService.getEmptyRecordDownExcel(startDate, endDate));

        boolean isAbove = Boolean.parseBoolean(aboveStandard);

        List list = countermeasures;
        List list2 = cService.transformPersonalAlmDataPattern(personalAlarms);//把各站亮燈頻率合併為橫式(類似 sql 的 Group by格式)
        List list3 = emptyRecords;

        if (list.isEmpty() || (list.isEmpty() && list2.isEmpty())) {
            res.setContentType("text/html");
            res.getWriter().println("fail");
        } else {
            Workbook w = this.generateBabDetailIntoExcel(list, list2, list3, isAbove);
            String fileExt = ExcelGenerator.getFileExt(w);

            res.setContentType("application/vnd.ms-excel");
            res.setHeader("Set-Cookie", "fileDownload=true; path=/");
            res.setHeader("Content-Disposition",
                    "attachment; filename=sampleData" + new DatetimeGenerator("yyyyMMdd").getToday() + fileExt);
            w.write(res.getOutputStream());
            w.close();
        }

        DateTime endTime = new DateTime();
        out.println("Total time processing: " + (Seconds.secondsBetween(startTime, endTime).getSeconds()) + " SEC.");
    }

    private List<Map> fitData(List data) {
        UserSelectFilter usf = new UserSelectFilter().setList(data);

        if (!"-1".equals(lineType)) {
            usf.filterData("lineType", lineType);
        }

        if (!"-1".equals(sitefloor)) {
            usf.filterData("sitefloor", Integer.parseInt(sitefloor));
        }

        return usf.getList();
    }

    private Workbook generateBabDetailIntoExcel(List<Map> countermeasures, List<Map> personalAlarms, List<Map> emptyRecords, boolean showAboveOnly) {

        String filterColumnName = "測量數量";
        String countermeasureSheetName = "異常填寫";
        String personalAlmSheetName = "亮燈頻率";
        String lastSheetName = "無儲存紀錄工單列表";

        List<Map> sheet1Data = new ArrayList(), sheet2Data = new ArrayList(), sheet3Data, sheet4Data = new ArrayList();
        List<Map> lastSheetData = emptyRecords;

        for (Map m : countermeasures) {
            if (m.containsKey(filterColumnName)) {
                if ((Integer) m.get(filterColumnName) >= minAllowAmount) {
                    sheet1Data.add(m);
                } else {
                    sheet2Data.add(m);
                }
            }
        }

        Iterator it = personalAlarms.iterator();
        while (it.hasNext()) {
            Map personalAlarm = (Map) it.next();
            for (Map cm : sheet2Data) {
                if (Objects.equals(cm.get("id"), personalAlarm.get("id"))) {
                    sheet4Data.add(personalAlarm);
                    it.remove();
                    break;
                }
            }
        }
        sheet3Data = personalAlarms;

        ExcelGenerator generator = new ExcelGenerator();

        generator.createExcelSheet(countermeasureSheetName + "(" + filterColumnName + "≧" + minAllowAmount + "台)");
        generator.generateWorkBooks(sheet1Data);

        generator.createExcelSheet(personalAlmSheetName + "(" + filterColumnName + "≧" + minAllowAmount + "台)");
        generator.appendSpecialPattern(sheet3Data, 9, "Z", "瓶頸站", "AA", "亮燈頻率");

        if (!showAboveOnly && !sheet2Data.isEmpty() && !sheet4Data.isEmpty()) {
            generator.createExcelSheet(countermeasureSheetName + "(" + filterColumnName + "<" + minAllowAmount + "台)");
            generator.generateWorkBooks(sheet2Data);
            generator.createExcelSheet(personalAlmSheetName + "(" + filterColumnName + "<" + minAllowAmount + "台)");
            generator.appendSpecialPattern(sheet4Data, 9, "Z", "瓶頸站", "AA", "亮燈頻率");
        }

        generator.createExcelSheet(lastSheetName);
        generator.generateWorkBooks(lastSheetData);

        return generator.getWorkbook();
    }

}
