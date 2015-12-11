package com.laboratoriodesoftware2015.hermesbucarbala.application;

import android.app.Activity;
import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import com.laboratoriodesoftware2015.hermesbucarbala.db.HermesSQLiteOpenHelper;

/**
 * Created by AGUSTIN.BALA on 09-12-15.
 */
public class HermesApplication extends Application {

    public static SQLiteOpenHelper sqLiteOpenHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sqLiteOpenHelper = new HermesSQLiteOpenHelper(getApplicationContext());
    }

}
