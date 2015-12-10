package com.laboratoriodesoftware2015.hermesbucarbala.domain;

/**
 * Created by AGUSTIN.BALA on 06-12-15.
 */
public class Pictogram {

    public static final String TABLE_NAME = "PICTOGRAM";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_FOLDER = "FOLDER";

    private long id;
    private String name;
    private String folder;

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

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
