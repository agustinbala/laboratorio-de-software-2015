package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnPictogram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class AlumnPictogramDAO extends BaseDAO<AlumnPictogram>  {
    @Override
    public void save(AlumnPictogram object) {

    }

    @Override
    public void update(AlumnPictogram object) {

    }

    @Override
    public void delete(AlumnPictogram object) {

    }

    @Override
    public List<AlumnPictogram> listAll() {
        return null;
    }

    @Override
    public AlumnPictogram get() {
        return null;
    }

    @Override
    public AlumnPictogram getById(long id) {
        return null;
    }

    public List<AlumnPictogram> listAllByAlumn(Integer alumnId) {
        List<AlumnPictogram> alumnPictogramList = new ArrayList<AlumnPictogram>();

        Cursor cursor = database.query(AlumnPictogram.TABLE_NAME, AlumnPictogram.ALL_COLUMNS, " ALUMN_ID = ?",
                new String[]{String.valueOf(alumnId)}, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            AlumnPictogram alumnPictogram = new AlumnPictogram(cursor.getInt(0), cursor.getInt(1));
            alumnPictogramList.add(alumnPictogram);
            cursor.moveToNext();
        }

        cursor.close();
        return alumnPictogramList;
    }
}
