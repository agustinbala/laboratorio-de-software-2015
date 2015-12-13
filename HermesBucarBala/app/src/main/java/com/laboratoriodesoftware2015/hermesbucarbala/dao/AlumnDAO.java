package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 09-12-15.
 */
public class AlumnDAO extends BaseDAO<Alumn> {


    @Override
    public void save(Alumn object) {
        ContentValues values = new ContentValues();
        values.put(Alumn.COLUMN_NAME, object.getName());
        values.put(Alumn.COLUMN_LASTNAME, object.getLastname());
        values.put(Alumn.COLUMN_GENDER, object.getGender().toString());
        long insertId = database.insert(Alumn.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(Alumn.TABLE_NAME,
                Alumn.ALL_COLUMNS, Alumn.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();
    }

    @Override
    public void update(Alumn object) {

    }

    @Override
    public  void delete(Alumn object) {

    }

    @Override
    public List<Alumn> listAll() {
        List<Alumn> alumns = new ArrayList<Alumn>();

        Cursor cursor = database.query(Alumn.TABLE_NAME, Alumn.ALL_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
                Alumn alumn = convertAlumn(cursor);
                alumns.add(alumn);
                cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return alumns;
    }

    @Override
    Alumn get() {
        return null;
    }

    @Override
    public Alumn getById(long id) {

        Cursor cursor =
                database.query(Alumn.TABLE_NAME,
                        Alumn.ALL_COLUMNS,
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();

        return convertAlumn(cursor);
    }

    private Alumn convertAlumn(Cursor cursor){
        Alumn alumn = new Alumn();
        alumn.setId(cursor.getInt(0));
        alumn.setName(cursor.getString(1));
        alumn.setLastname(cursor.getString(2));
        alumn.setGender(cursor.getString(3).charAt(0));
        alumn.setSize(cursor.getString(4));
        return alumn;
    }
}
