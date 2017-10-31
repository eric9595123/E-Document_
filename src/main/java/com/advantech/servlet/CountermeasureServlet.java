/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 組包裝異常回覆的CRUD
 */
package com.advantech.servlet;

import com.advantech.entity.Countermeasure;
import com.advantech.service.CountermeasureService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Wei.Cheng
 */
@Controller
@RequestMapping("/CountermeasureServlet")
public class CountermeasureServlet {

    private static final Logger log = LoggerFactory.getLogger(CountermeasureServlet.class);

    @Autowired
    private CountermeasureService cService;

    @RequestMapping(value = "/findOne", method = {RequestMethod.GET})
    @ResponseBody
    protected Countermeasure findOne(@RequestParam int BABid) {
        Countermeasure cm = cService.getCountermeasure(BABid);
        if (cm != null) {
            cm.setErrorCodes(cService.getErrorCode(cm.getId()));
            cm.setEditors(cService.getEditor(cm.getId()));
        }
        return cm;
    }

    @RequestMapping(value = "/findAll", method = {RequestMethod.GET})
    @ResponseBody
    protected List<Countermeasure> findAll() {
        return cService.getCountermeasure();
    }

    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    @ResponseBody
    protected boolean update(
            @RequestParam int BABid,
            @RequestParam(value = "actionCodes[]") String[] actionCodes,
            @RequestParam String solution,
            @RequestParam String editor
    ) {
        return cService.updateCountermeasure(BABid, Arrays.asList(actionCodes), solution, editor);
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    @ResponseBody
    protected boolean delete(@RequestParam int id) {
        return cService.deleteCountermeasure(id);
    }

    @RequestMapping(value = "/getErrorCode", method = {RequestMethod.GET})
    @ResponseBody
    protected List getErrorCode() {
        return cService.getErrorCode();
    }

    @RequestMapping(value = "/getActionCode", method = {RequestMethod.GET})
    @ResponseBody
    protected List getActionCode() {
        return cService.getActionCode();
    }

}
