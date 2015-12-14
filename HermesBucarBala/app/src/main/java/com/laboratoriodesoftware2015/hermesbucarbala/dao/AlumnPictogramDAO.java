package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.content.ContentValues;
import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnPictogram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class AlumnPictogramDAO extends BaseDAO<AlumnPictogram>  {
    @Override
    public void save(AlumnPictogram object) {
        ContentValues values = new ContentValues();
        values.put(AlumnPictogram.COLUMN_ALUMN_ID, object.getAlumnId());
        values.put(AlumnPictogram.COLUMN_PICTOGRAM_ID, object.getPictogramId());
        database.insert(AlumnPictogram.TABLE_NAME, null,
                values);
    }

    @Override
    public void update(AlumnPictogram object) {

    }

    @Override
    public void delete(AlumnPictogram object) {
        database.delete(AlumnPictogram.TABLE_NAME, AlumnPictogram.COLUMN_ALUMN_ID+" = "+ object.getAlumnId()+
                " and "+AlumnPictogram.COLUMN_PICTOGRAM_ID+" = "+object.getPictogramId(), null);
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

    public AlumnPictogram get(Integer alumnId, Integer pictogramId){
        Cursor cursor =
                database.query(AlumnPictogram.TABLE_NAME,
                        AlumnPictogram.ALL_COLUMNS,
                        AlumnPictogram.COLUMN_ALUMN_ID+" = "+alumnId+" and "+
                        AlumnPictogram.COLUMN_PICTOGRAM_ID+ " = "+pictogramId,
                        null,
                        null,
                        null,
                        null,
                        null);


        if (cursor != null) {
            cursor.moveToFirst();
            if(cursor.getCount() > 0) {
                AlumnPictogram alumnPictogram = new AlumnPictogram(cursor.getInt(0), cursor.getInt(1));
                cursor.close();
                return alumnPictogram;
            } else {
                return null;
            }
        } else {
            cursor.close();
            return null;
        }


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
