package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.database.sqlite.SQLiteDatabase;

import com.laboratoriodesoftware2015.hermesbucarbala.application.HermesApplication;

/**
 * Created by AGUSTIN.BALA on 09-12-15.
 */
public abstract class BaseDAO<T> {

    protected SQLiteDatabase database;

    public BaseDAO(){
        this.database = HermesApplication.sqLiteOpenHelper.getWritableDatabase();
    }

    abstract void save(T object);

    abstract void update(T object);

    abstract void delete(T object);

    abstract T get();


}
