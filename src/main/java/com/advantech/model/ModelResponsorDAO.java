/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.model;

import com.advantech.entity.ModelResponsor;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wei.Cheng
 */
public class ModelResponsorDAO extends BasicDAO {

    public ModelResponsorDAO() {

    }

    private Connection getConn() {
        return getDBUtilConn(SQL.Way_Chien_WebAccess);
    }

    private List<ModelResponsor> queryModelResponsorTable(String sql, Object... params) {
        return queryForBeanList(getConn(), ModelResponsor.class, sql, params);
    }

    public List<ModelResponsor> getModelResponsor() {
        return queryModelResponsorTable("SELECT * FROM ModelResponsorView");
    }

    public List<Map> getModelResponsor1() {
        return queryForMapList(this.getConn(), "SELECT * FROM ModelResponsorView");
    }

    public List<ModelResponsor> getModelResponsor(String modelName) {
        return queryModelResponsorTable("SELECT * FROM ModelResponsorView WHERE Model_name = ?", modelName);
    }

    public String getModelResponsor(String departmentCode, String modelName) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(departmentCode);
        sb.append("_Owner");
        sb.append(" FROM ModelResponsorView WHERE Model_name = ?");
        List<Map> l = queryForMapList(this.getConn(), sb.toString(), modelName);
        if (l.isEmpty()) {
            return null;
        } else {
            Map m = l.get(0);
            return m.toString();
        }
    }
}
