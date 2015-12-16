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

    public static final String SIZE_SMALL = "CHICO";
    public static final String SIZE_MEDIUM = "MEDIANO";
    public static final String SIZE_BIG= "GRANDE";

    public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_NAME, COLUMN_LASTNAME, COLUMN_GENDER, COLUMN_SIZE };



    private Integer id;
    private String name;
    private String lastname;
    private Character gender;
    private String size;
    private List<Tab> tabs;
    private List<Pictogram> pictograms;

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

    public List<Pictogram> getPictograms() {
        return pictograms;
    }

    public void setPictograms(List<Pictogram> pictograms) {
        this.pictograms = pictograms;
    }

    public Alumn(String name, String lastname, Character gender, String size) {
        this.name = name;
        this.lastname = lastname;
        this.gender = gender;
        this.size = size;
    }

    public Alumn() {
        super();
    }
}
