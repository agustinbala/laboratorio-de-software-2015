package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.laboratoriodesoftware2015.hermesbucarbala.application.HermesApplication;

import java.util.List;

/**
 * Created by AGUSTIN.BALA on 09-12-15.
 */
public abstract class BaseDAO<T> {

    protected SQLiteDatabase database;
    protected SQLiteOpenHelper dbHelper;

    public BaseDAO(){
        this.dbHelper = HermesApplication.sqLiteOpenHelper;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    abstract void save(T object);

    abstract void update(T object);

    abstract void delete(T object);

    abstract List<T> listAll();

    abstract T get();


}
