/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.model;

import com.advantech.entity.LineOwnerMapping;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Wei.Cheng
 */
@Repository
public class LineOwnerMappingDAO extends BasicDAO {

    private Connection getConn() {
        return getDBUtilConn(SQL.WebAccess);
    }

    private List<LineOwnerMapping> query(String sql, Object... params) {
        return queryForBeanList(this.getConn(), LineOwnerMapping.class, sql, params);
    }

    public List<LineOwnerMapping> getAll() {
        return this.query("SELECT * FROM LineOwnerMapping");
    }

    public List<LineOwnerMapping> getOne(int id) {
        return this.query("SELECT * FROM LineOwnerMapping WHERE id = ?", id);
    }

    public List<LineOwnerMapping> getByLine(int lineId) {
        return this.query("SELECT * FROM LineOwnerMapping WHERE line_id = ?", lineId);
    }

    public List<Map> getLineOwnerMappingView() {
        return queryForMapList(this.getConn(), "SELECT * FROM lineOwnerMappingView");
    }

    public List<Map> getLineNotSetting() {
        return queryForMapList(this.getConn(), "SELECT * FROM LineOwnerMappingView WHERE line_id IS NULL");
    }

    public List<Map> getResponsorPerSitefloorView() {
        return queryForMapList(this.getConn(), "SELECT * FROM responsorPerSitefloorView");
    }

}
