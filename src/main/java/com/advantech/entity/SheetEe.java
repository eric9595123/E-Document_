package com.advantech.entity;
// Generated 2017/3/13 上午 09:50:39 by Hibernate Tools 4.3.1

import com.google.gson.annotations.Expose;
import java.math.BigDecimal;
import java.util.Date;

/**
 * SheetEe generated by hbm2java
 */
public class SheetEe implements java.io.Serializable {

    @Expose
    private int id;
    @Expose
    private Model model;
    @Expose
    private BigDecimal t1;
    @Expose
    private BigDecimal t2;
    @Expose
    private BigDecimal t3;
    @Expose
    private BigDecimal t4;
    @Expose
    private BigDecimal upBiRi;
    @Expose
    private BigDecimal downBiRi;
    @Expose
    private String testSop;
    @Expose
    private Date modifiedDate;

    public SheetEe() {
    }

    public SheetEe(int id) {
        this.id = id;
    }

    public SheetEe(int id, Model model, BigDecimal t1, BigDecimal t2, BigDecimal t3, BigDecimal t4, BigDecimal upBiRi, BigDecimal downBiRi, String testSop, Date modifiedDate) {
        this.id = id;
        this.model = model;
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
        this.t4 = t4;
        this.upBiRi = upBiRi;
        this.downBiRi = downBiRi;
        this.testSop = testSop;
        this.modifiedDate = modifiedDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public BigDecimal getT1() {
        return this.t1;
    }

    public void setT1(BigDecimal t1) {
        this.t1 = t1;
    }

    public BigDecimal getT2() {
        return this.t2;
    }

    public void setT2(BigDecimal t2) {
        this.t2 = t2;
    }

    public BigDecimal getT3() {
        return this.t3;
    }

    public void setT3(BigDecimal t3) {
        this.t3 = t3;
    }

    public BigDecimal getT4() {
        return this.t4;
    }

    public void setT4(BigDecimal t4) {
        this.t4 = t4;
    }

    public BigDecimal getUpBiRi() {
        return this.upBiRi;
    }

    public void setUpBiRi(BigDecimal upBiRi) {
        this.upBiRi = upBiRi;
    }

    public BigDecimal getDownBiRi() {
        return this.downBiRi;
    }

    public void setDownBiRi(BigDecimal downBiRi) {
        this.downBiRi = downBiRi;
    }

    public String getTestSop() {
        return this.testSop;
    }

    public void setTestSop(String testSop) {
        this.testSop = testSop;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
