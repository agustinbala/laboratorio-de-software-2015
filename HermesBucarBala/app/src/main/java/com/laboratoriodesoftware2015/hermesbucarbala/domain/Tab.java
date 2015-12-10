package com.laboratoriodesoftware2015.hermesbucarbala.domain;

/**
 * Created by AGUSTIN.BALA on 06-12-15.
 */
public class Tab {

    public static final String TABLE_NAME = "TAB";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
