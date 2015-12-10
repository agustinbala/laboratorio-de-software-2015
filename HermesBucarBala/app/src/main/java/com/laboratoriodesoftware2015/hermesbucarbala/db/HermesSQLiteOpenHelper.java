package com.laboratoriodesoftware2015.hermesbucarbala.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumno;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;

/**
 * Created by AGUSTIN.BALA on 06-12-15.
 */
public class HermesSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "hermes.db";
    private static final int DATABASE_VERSION = 1;

    public HermesSQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Alumno.TABLE_NAME+" ( "+ Alumno.COLUMN_ID+" INT  PRIMARY KEY NOT NULL, "+ Alumno.COLUMN_NAME+" TEXT NOT NULL, "+ Alumno.COLUMN_LASTNAME+" TEXT NOT NULL, "+ Alumno.COLUMN_GENDER+"  CHAR(1) NOT NULL, "+ Alumno.COLUMN_SIZE+" TEXT )");
        db.execSQL("CREATE TABLE "+Tab.TABLE_NAME+" ( "+Tab.COLUMN_ID+" INT PRIMARY KEY NOT NULL, "+Tab.COLUMN_NAME+" TEXT NOT NULL )");
        db.execSQL("CREATE TABLE "+ Alumno.ALUMN_TAB_TABLE_NAME+" ( "+ Alumno.ALUMN_TAB_COLUMN_ALUMN_ID+" INT NOT NULL, "+ Alumno.ALUMN_TAB_COLUMN_TAB_ID+" INT KEY NOT NULL )");
        db.execSQL("CREATE TABLE "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_ID+" INT PRIMARY KEY NOT NULL, "+Pictogram.COLUMN_NAME+" TEXT NOT NULL, "+Pictogram.COLUMN_FOLDER+" TEXT NOT NULL )");
        db.execSQL("CREATE TABLE "+ Alumno.ALUMN_PICTOGRAM_TABLE_NAME+" ( "+ Alumno.ALUMN_PICTOGRAM_COLUMN_ALUMN_ID+" INT NOT NULL, "+ Alumno.ALUMN_PICTOGRAM_COLUMN_PICTOGRAM_ID+" INT NOT NULL)");
        db.execSQL("CREATE TABLE "+Configuration.TABLE_NAME+" ( "+Configuration.COLUMN_ID+" INT PRIMARY KEY NOT NULL, "+Configuration.COLUMN_SERVER+" TEXT NOT NULL, "+Configuration.COLUMN_PORT+" TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Alumno.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Tab.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Alumno.ALUMN_TAB_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Pictogram.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Alumno.ALUMN_PICTOGRAM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Configuration.TABLE_NAME);
        onCreate(db);
    }
}
