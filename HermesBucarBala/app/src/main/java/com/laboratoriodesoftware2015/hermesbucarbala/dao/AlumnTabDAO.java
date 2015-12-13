package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;

import java.util.List;

/**
 * Created by natalia on 12/12/15.
 */
public class AlumnTabDAO extends BaseDAO<Alumn> {
    @Override
    public void save(Alumn object) {

        ContentValues values = new ContentValues();
        values.put(Alumn.ALUMN_TAB_COLUMN_ALUMN_ID, object.getId());
        values.put(Alumn.ALUMN_TAB_COLUMN_TAB_ID, object.getTabs().get(0).getId());
        Cursor cursor = database.query(Alumn.ALUMN_TAB_TABLE_NAME,
                Alumn.ALL_COLUMNS_ALUM_TAB_TABLE, Alumn.ALUMN_TAB_COLUMN_ALUMN_ID+ " = " + object.getId(), null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();

    }

    @Override
    void update(Alumn object) {

    }

    @Override
    public void delete(Alumn object) {


        database.delete(Alumn.ALUMN_TAB_TABLE_NAME,
                Alumn.ALUMN_TAB_COLUMN_ALUMN_ID + " = ?",
                new String[]{String.valueOf(object.getId())});

    }

    @Override
    List<Alumn> listAll() {
        return null;
    }

    @Override
    Alumn get() {
        return null;
    }

    @Override
    Alumn getById(long id) {
        return null;
    }
}
