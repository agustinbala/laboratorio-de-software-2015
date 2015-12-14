package com.laboratoriodesoftware2015.hermesbucarbala.domain;

import java.io.Serializable;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class AlumnPictogram implements Serializable {

    public static final String TABLE_NAME = "ALUMN_PICTOGRAM";
    public static final String COLUMN_ALUMN_ID = "ALUMN_ID";
    public static final String COLUMN_PICTOGRAM_ID = "PICTOGRAM_ID";

    public static final String[] ALL_COLUMNS = { COLUMN_ALUMN_ID, COLUMN_PICTOGRAM_ID };

    private Integer alumnId;
    private Integer pictogramId;

    public Integer getAlumnId() {
        return alumnId;
    }

    public void setAlumnId(Integer alumnId) {
        this.alumnId = alumnId;
    }

    public Integer getPictogramId() {
        return pictogramId;
    }

    public void setPictogramId(Integer pictogramId) {
        this.pictogramId = pictogramId;
    }

    public AlumnPictogram(Integer alumnId, Integer pictogramId){
        this.alumnId = alumnId;
        this.pictogramId = pictogramId;
    }
}
