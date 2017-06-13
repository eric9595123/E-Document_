/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 取得該工單每pcs的線平衡
 */
package com.advantech.servlet;

import com.advantech.entity.BABStatus;
import com.advantech.helper.ParamChecker;
import com.advantech.service.BABService;
import com.advantech.service.BasicService;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.json.JSONObject;

/**
 *
 * @author Wei.Cheng
 */
@WebServlet(name = "LineBalanceDetail", urlPatterns = {"/LineBalanceDetail"})
public class LineBalanceDetail extends HttpServlet {

    private BABService babService = null;
    private ParamChecker pChecker = null;

    @Override
    public void init() throws ServletException {
        babService = BasicService.getBabService();
        pChecker = new ParamChecker();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.sendError(HttpServletResponse.SC_FORBIDDEN);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        String id = req.getParameter("id");
        String isused = req.getParameter("isused");
        List balnPerGroup;
        if (pChecker.checkInputVals(id)) {
            int i = Integer.parseInt(id);
            BABStatus status = isused == null ? null : BABStatus.CLOSED;
            balnPerGroup = babService.getLineBalanceDetail(i, status);
        } else {
            balnPerGroup = new ArrayList();
        }
        out.print(new JSONObject().put("data", balnPerGroup));
    }
}
