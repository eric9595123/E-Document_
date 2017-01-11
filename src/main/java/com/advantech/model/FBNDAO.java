/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.model;

import com.advantech.entity.FBN;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wei.Cheng
 */
public class FBNDAO extends BasicDAO {

    public FBNDAO() {

    }

    private Connection getConn() {
        return getDBUtilConn(SQL.Way_Chien_WebAccess);
    }

    private List<FBN> queryFBNTable(String sql, Object... params) {
        return queryForBeanList(getConn(), FBN.class, sql, params);
    }

    public List<FBN> getSensorDataInDay() {
        return queryFBNTable("SELECT * FROM LS_FBN_Sort");
    }

    public FBN getLastInputData() {
        List l = queryFBNTable("SELECT TOP 1 * FROM LS_FBN_Sort ORDER BY ID DESC");
        return !l.isEmpty() ? (FBN) l.get(0) : null;
    }

    //利用檢視表(過濾後FBN資料表資訊)得到當前sensor時間 websocket用 
    public List<Map> getSensorCurrentStatus() {
        return queryForMapList(getConn(), "SELECT * FROM LS_GetSenRealTime");
    }

    public List<FBN> getSensorStatus(int BABid) {
        return queryFBNTable("{CALL sp_sensorStatus(?)}", BABid);
    }

    public List<Map> getBalancePerGroup(int BABid) {
        return queryForMapList(getConn(), "SELECT * FROM LS_balanceDetailPerGroup(?)", BABid);
    }

    public FBN getBABFinalStationSensorStatus(int BABid) {
        List l = queryProcForBeanList(getConn(), FBN.class, "{CALL LS_babFinalStationSensorStatus(?)}", BABid);
        return l.isEmpty() ? null : (FBN) l.get(0);
    }

    public List<Map> getTotalAbnormalData(int BABid) {
        return queryProcForMapList(getConn(), "{CALL sensorTotalAbnormalCheck(?)}", BABid);
    }

    public List<Map> getAbnormalData(int BABid) {
        return queryProcForMapList(getConn(), "{CALL sensorAbnormalCheck(?)}", BABid);
    }

    public boolean sensorDataClean(String date) {
        return updateProc(this.getConn(), "{CALL sensorDataCleanProc(?)}", date);
    }
}
