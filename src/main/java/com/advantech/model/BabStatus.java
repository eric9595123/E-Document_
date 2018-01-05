/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advantech.model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Wei.Cheng
 */
public enum BabStatus {
    CLOSED(1),
    NO_RECORD(-1),
    UNFINSHED(-2);
 
    private final Integer value;
    private static final Map map = new HashMap<>();
 
    private BabStatus(Integer value) {
        this.value = value;
    }
    
    static {
        for (BabStatus b : BabStatus.values()) {
            map.put(b.value, b);
        }
    }

    public static BabStatus valueOf(int pageType) {
        return (BabStatus) map.get(pageType);
    }
 
    public Integer getValue() {
        return this.value;
    }
}
