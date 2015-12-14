package com.laboratoriodesoftware2015.hermesbucarbala.domain;

/**
 * Created by AGUSTIN.BALA on 06-12-15.
 */
public class Tab {

    public static final String TABLE_NAME = "TAB";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";

    public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_NAME};

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tab(String name){
        setName(name);
    }

}
