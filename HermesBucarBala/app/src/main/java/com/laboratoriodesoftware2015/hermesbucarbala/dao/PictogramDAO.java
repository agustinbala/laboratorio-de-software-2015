package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class PictogramDAO extends  BaseDAO<Pictogram> {

    @Override
    public void save(Pictogram object) {

    }

    @Override
    public void update(Pictogram object) {

    }

    @Override
    public void delete(Pictogram object) {

    }

    @Override
    public List<Pictogram> listAll() {
        List<Pictogram> pictogramList = new ArrayList<Pictogram>();

        Cursor cursor = database.query(Pictogram.TABLE_NAME, Pictogram.ALL_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Pictogram pictogram = new Pictogram();
            pictogram.setId(cursor.getInt(0));
            pictogram.setName(cursor.getString(1));
            pictogram.setFolder(cursor.getString(2));
            pictogramList.add(pictogram);
            cursor.moveToNext();
        }

        cursor.close();
        return pictogramList;
    }

    @Override
    public Pictogram get() {
        return null;
    }

    @Override
    public Pictogram getById(long id) {
        return null;
    }
}
