/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.entity;

import java.io.Serializable;

/**
 *
 * @author Wei.Cheng
 */
public class BABLoginStatus implements Serializable {

    private int id;
    private int lineId;
    private int station;
    private String jobnumber;

    public BABLoginStatus() {
    }

    public BABLoginStatus(int BABid, int station, String jobnumber) {
        this.lineId = BABid;
        this.station = station;
        this.jobnumber = jobnumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int BABid) {
        this.lineId = BABid;
    }

    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

}
