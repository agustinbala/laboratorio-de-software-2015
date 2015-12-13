package com.laboratoriodesoftware2015.hermesbucarbala.dao;

import android.database.Cursor;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natalia on 12/12/15.
 */
public class TabDAO extends BaseDAO<Tab> {
    @Override
    public void save(Tab object) {

    }

    @Override
    public void update(Tab object) {

    }

    @Override
    public void delete(Tab object) {

    }

    @Override
    public List<Tab> listAll() {
        List<Tab> tabs = new ArrayList<Tab>();

        Cursor cursor = database.query(Tab.TABLE_NAME, Tab.ALL_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Tab tab = new Tab(cursor.getString(1));
            tab.setId(cursor.getInt(0));
            tabs.add(tab);
            cursor.moveToNext();
        }

        cursor.close();
        return tabs;
    }

    @Override
    public Tab get() {
        return null;
    }

    @Override
    public Tab getById(long id) {

        Tab tab = null;
        Cursor cursorTab =
                database.query(Tab.TABLE_NAME,
                        Tab.ALL_COLUMNS,
                        " id = ?",
                        new String[]{String.valueOf(id)},
                        null,
                        null,
                        null,
                        null);
        if(cursorTab !=null) {
            cursorTab.moveToFirst();
             tab = new Tab(cursorTab.getString(1));
            tab.setId(cursorTab.getInt(0));
        }
        return tab;

    }
}
