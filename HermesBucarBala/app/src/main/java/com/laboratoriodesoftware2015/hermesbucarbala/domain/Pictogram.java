package com.laboratoriodesoftware2015.hermesbucarbala.domain;

/**
 * Created by AGUSTIN.BALA on 06-12-15.
 */
public class Pictogram {

    public static final String TABLE_NAME = "PICTOGRAM";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_FOLDER = "FOLDER";

    public static final String[] ALL_COLUMNS = { COLUMN_ID, COLUMN_NAME, COLUMN_FOLDER};

    private Integer id;
    private String name;
    private String folder;

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

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pictogram pictogram = (Pictogram) o;

        return id == pictogram.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
