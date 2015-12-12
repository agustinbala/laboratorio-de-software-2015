package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.content.ContentValues;
import android.database.Cursor;


import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationDAO extends BaseDAO<Configuration> {
    @Override
    public void save(Configuration object) {

        ContentValues values = new ContentValues();
        values.put(Configuration.COLUMN_PORT, object.getPort());
        values.put(Configuration.COLUMN_SERVER, object.getServer());
        long insertId = database.insert(Configuration.TABLE_NAME, null,
                values);
        Cursor cursor = database.query(Configuration.TABLE_NAME,
                Configuration.ALL_COLUMNS, Configuration.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        cursor.close();

    }

    @Override
    public void update(Configuration object) {

        ContentValues values = new ContentValues();
        values.put(Configuration.COLUMN_PORT, object.getPort());
        values.put(Configuration.COLUMN_SERVER, object.getServer());
        // 3. updating row
        int i = database.update(Configuration.TABLE_NAME,
                values,
                Configuration.COLUMN_ID+" = ?",
                new String[] { String.valueOf(object.getId()) });

    }

    @Override
    public void delete(Configuration object) {

    }

    @Override
    public List<Configuration> listAll() {
        return null;
    }

    @Override
    public Configuration get() {
        List<Configuration> configurations = new ArrayList<Configuration>();

        Cursor cursor = database.query(Configuration.TABLE_NAME, Configuration.ALL_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Configuration configuration = new Configuration();
            configuration.setId(cursor.getInt(0));
            configuration.setPort(cursor.getString(1));
            configuration.setServer(cursor.getString(2));
            configurations.add(configuration);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        if(configurations.size()> 0) {
            return configurations.get(0);
        }else{
             return null;
        }
    }

    @Override
    public Configuration getById(long id) {return null;}
}
