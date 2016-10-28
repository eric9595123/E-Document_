/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 顯示看板XML是否有資料用 與其他class無相依關係(開看板刷新時用，若無需求可刪除此servlet)
 */
package com.advantech.test;

import com.advantech.model.BasicDAO;
import com.advantech.quartzJob.CountermeasureAlarm;
import com.advantech.service.BasicService;
import com.advantech.service.CountermeasureService;
import java.io.*;
import static java.lang.System.out;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wei.Cheng
 */
@WebServlet(name = "TestServlet", urlPatterns = {"/TestServlet"})
public class TestServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(TestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        BasicDAO.dataSourceInit1();
        String lineType = "-1", sitefloor = "-1", startDate = req.getParameter("startDate"), endDate = req.getParameter("endDate");
        CountermeasureService cs = BasicService.getCountermeasureService();
//        List countermeasures = cs.getCountermeasure(lineType, sitefloor, startDate, endDate);
//        List personalAlarms = cs.getPersonalAlm(lineType, sitefloor, startDate, endDate);
//        out.println(countermeasures);
//        out.println(personalAlarms);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        String id = req.getParameter("id");
        out.println(BasicService.getBabService().getAvg(Integer.parseInt(id)));
    }
}
