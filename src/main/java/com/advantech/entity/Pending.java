package com.advantech.entity;
// Generated 2017/3/13 上午 09:50:39 by Hibernate Tools 4.3.1

import com.google.gson.annotations.Expose;
import java.math.BigDecimal;

/**
 * Pending generated by hbm2java
 */
public class Pending implements java.io.Serializable {

    @Expose
    private int id;
    @Expose
    private SheetSpe sheetSpe;
    @Expose
    private String typeName;
    @Expose
    private BigDecimal time;

    public Pending() {
    }

    public Pending(int id) {
        this.id = id;
    }

    public Pending(int id, SheetSpe sheetSpe, String typeName, BigDecimal time) {
        this.id = id;
        this.sheetSpe = sheetSpe;
        this.typeName = typeName;
        this.time = time;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SheetSpe getSheetSpe() {
        return this.sheetSpe;
    }

    public void setSheetSpe(SheetSpe sheetSpe) {
        this.sheetSpe = sheetSpe;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getTime() {
        return this.time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

}
