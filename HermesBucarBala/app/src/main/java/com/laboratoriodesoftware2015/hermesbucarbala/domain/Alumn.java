package com.laboratoriodesoftware2015.hermesbucarbala.domain;

import java.io.Serializable;
import java.util.List;

public class Alumn implements Serializable{

    public static final String TABLE_NAME = "ALUMN";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_LASTNAME = "LASTNAME";
    public static final String COLUMN_GENDER = "GENDER";
    public static final String COLUMN_SIZE = "SIZE";

    public static final String ALUMN_TAB_TABLE_NAME = "ALUMN_TAB";
    public static final String ALUMN_TAB_COLUMN_ALUMN_ID = "ALUMN_ID";
    public static final String ALUMN_TAB_COLUMN_TAB_ID = "TAB_ID";

    public static final String ALUMN_PICTOGRAM_TABLE_NAME = "ALUMN_PICTOGRAM";
    public static final String ALUMN_PICTOGRAM_COLUMN_ALUMN_ID = "ALUMN_ID";
    public static final String ALUMN_PICTOGRAM_COLUMN_PICTOGRAM_ID = "PICTOGRAM_ID";

    public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_NAME, COLUMN_LASTNAME };


    private long id;
    private String name;
    private String lastname;
    private Character gender;
    private String size;
    private List<Tab> tabs;

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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(List<Tab> tabs) {
        this.tabs = tabs;
    }

    public Alumn(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Alumn() {
        super();
    }
}
