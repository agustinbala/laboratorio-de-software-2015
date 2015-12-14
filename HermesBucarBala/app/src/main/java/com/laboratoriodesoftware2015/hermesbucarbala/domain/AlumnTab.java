package com.laboratoriodesoftware2015.hermesbucarbala.domain;

import java.io.Serializable;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class AlumnTab implements Serializable {

    public static final String TABLE_NAME = "ALUMN_TAB";
    public static final String COLUMN_ALUMN_ID = "ALUMN_ID";
    public static final String COLUMN_TAB_ID = "TAB_ID";

    public static final String[] ALL_COLUMNS = { COLUMN_ALUMN_ID, COLUMN_TAB_ID};

    private Integer alumnId;
    private Integer tabId;

    public Integer getAlumnId() {
        return alumnId;
    }

    public Integer getTabId() {
        return tabId;
    }

    public void setAlumnId(Integer alumnId) {
        this.alumnId = alumnId;
    }

    public void setTabId(Integer tabId) {
        this.tabId = tabId;
    }

    public AlumnTab(Integer alumnId, Integer tabId){
        this.alumnId = alumnId;
        this.tabId = tabId;
    }
}
