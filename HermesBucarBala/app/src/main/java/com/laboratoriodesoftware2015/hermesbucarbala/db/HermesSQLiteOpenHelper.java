package com.laboratoriodesoftware2015.hermesbucarbala.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnPictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnTab;
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
        db.execSQL("CREATE TABLE "+ Alumn.TABLE_NAME+" ( "+ Alumn.COLUMN_ID+" INTEGER  PRIMARY KEY autoincrement, "+ Alumn.COLUMN_NAME+" TEXT NOT NULL, "+ Alumn.COLUMN_LASTNAME+" TEXT NOT NULL, "+ Alumn.COLUMN_GENDER+"  CHAR(1) , "+ Alumn.COLUMN_SIZE+" TEXT )");
        db.execSQL("CREATE TABLE "+Tab.TABLE_NAME+" ( "+Tab.COLUMN_ID+" INTEGER PRIMARY KEY autoincrement, "+Tab.COLUMN_NAME+" TEXT NOT NULL )");
        db.execSQL("CREATE TABLE "+ AlumnTab.TABLE_NAME+" ( "+ AlumnTab.COLUMN_ALUMN_ID+" INT NOT NULL, "+ AlumnTab.COLUMN_TAB_ID+" INT KEY NOT NULL )");
        db.execSQL("CREATE TABLE "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_ID+" INTEGER PRIMARY KEY autoincrement, "+Pictogram.COLUMN_NAME+" TEXT NOT NULL, "+Pictogram.COLUMN_FOLDER+" TEXT NOT NULL )");
        db.execSQL("CREATE TABLE "+ AlumnPictogram.TABLE_NAME+" ( "+ AlumnPictogram.COLUMN_ALUMN_ID+" INT NOT NULL, "+ AlumnPictogram.COLUMN_PICTOGRAM_ID+" INT NOT NULL)");
        db.execSQL("CREATE TABLE "+Configuration.TABLE_NAME+" ( "+Configuration.COLUMN_ID+" INTEGER PRIMARY KEY autoincrement, "+Configuration.COLUMN_SERVER+" TEXT NOT NULL, "+Configuration.COLUMN_PORT+" TEXT NOT NULL )");

        loadData(db);
    }

    private void loadData(SQLiteDatabase db) {
        db.execSQL("INSERT INTO "+Tab.TABLE_NAME+" ( "+Tab.COLUMN_NAME+" ) VALUES ('establo')");
        db.execSQL("INSERT INTO "+Tab.TABLE_NAME+" ( "+Tab.COLUMN_NAME+" ) VALUES ('pista')");
        db.execSQL("INSERT INTO "+Tab.TABLE_NAME+" ( "+Tab.COLUMN_NAME+" ) VALUES ('necesidades')");
        db.execSQL("INSERT INTO " + Tab.TABLE_NAME + " ( " + Tab.COLUMN_NAME + " ) VALUES ('emociones')");

        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('asustada', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('asustado', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('cansada', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('cansado', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('contento', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('contenta', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('dolorida', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('dolorido', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('enojada', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('enojado', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('sorprendida', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('sorprendido', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('triste_nena', 'emociones')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('triste_nene', 'emociones')");


        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('caballo', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('caballo2', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('caballo3', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('cepillo', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('escarbavasos', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('limpieza', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('matra', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('montura', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('pasto', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('rasquetablanda', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('rasquetadura', 'establo')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('zanahoria', 'establo')");

        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('banio', 'necesidades')");
        //db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('no', 'necesidades')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('sed_nena', 'necesidades')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('sed_nene', 'necesidades')");
       // db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('si', 'necesidades')");

        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('aro', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('broches', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('burbujas', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('casco', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('chapas', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('cubos', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('letras', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('maracas', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('palos', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('pato', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('pelota', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('riendas', 'pista')");
        db.execSQL("INSERT INTO "+Pictogram.TABLE_NAME+" ( "+Pictogram.COLUMN_NAME+" , "+Pictogram.COLUMN_FOLDER+" ) VALUES ('tarima', 'pista')");

        db.execSQL("INSERT INTO "+AlumnPictogram.TABLE_NAME+" ( "+AlumnPictogram.COLUMN_ALUMN_ID+" , "+AlumnPictogram.COLUMN_PICTOGRAM_ID+" ) VALUES (1, 1)");
        db.execSQL("INSERT INTO "+AlumnPictogram.TABLE_NAME+" ( "+AlumnPictogram.COLUMN_ALUMN_ID+" , "+AlumnPictogram.COLUMN_PICTOGRAM_ID+" ) VALUES (1, 16)");
        db.execSQL("INSERT INTO "+AlumnPictogram.TABLE_NAME+" ( "+AlumnPictogram.COLUMN_ALUMN_ID+" , "+AlumnPictogram.COLUMN_PICTOGRAM_ID+" ) VALUES (1, 27)");
        db.execSQL("INSERT INTO "+AlumnPictogram.TABLE_NAME+" ( "+AlumnPictogram.COLUMN_ALUMN_ID+" , "+AlumnPictogram.COLUMN_PICTOGRAM_ID+" ) VALUES (1, 41)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Alumn.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Tab.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ AlumnTab.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Pictogram.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ AlumnPictogram.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ Configuration.TABLE_NAME);
        onCreate(db);
    }
}
