package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnTab;

import java.util.List;

/**
 * Created by natalia on 12/12/15.
 */
public class AlumnTabDAO extends BaseDAO<AlumnTab> {

    @Override
    public void save(AlumnTab object) {
        ContentValues values = new ContentValues();
        values.put(AlumnTab.COLUMN_ALUMN_ID, object.getAlumnId());
        values.put(AlumnTab.COLUMN_TAB_ID, object.getTabId());
        database.insert(AlumnTab.TABLE_NAME, null,
                values);
    }

    @Override
    public void update(AlumnTab object) {
    }

    @Override
    public void delete(AlumnTab object) {
        database.delete(AlumnTab.TABLE_NAME,
                AlumnTab.COLUMN_ALUMN_ID + " = ? and " +
                AlumnTab.COLUMN_TAB_ID + " = ?",
                new String[]{String.valueOf(object.getAlumnId()),
                        String.valueOf(object.getTabId())});
    }

    @Override
    public List<AlumnTab> listAll() {
        return null;
    }

    @Override
    public AlumnTab get() {
        return null;
    }

    @Override
    public AlumnTab getById(long id) {
        return null;
    }
}
