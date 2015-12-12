package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import android.app.Activity;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.db.HermesSQLiteOpenHelper;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.view.LoginView;

import java.util.List;

/**
 * Created by AGUSTIN.BALA on 09-12-15.
 */
public class LoginPresenter {

    private LoginView callback;
    private AlumnDAO alumnDAO;

    public LoginPresenter(LoginView activity){
        this.callback = activity;
        this.alumnDAO = new AlumnDAO();
    }


    public void getAlumns(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                alumnDAO.open();
                final List<Alumn> alumnList =  alumnDAO.listAll();
                ((Activity)callback).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onListAlumns(alumnList);
                    }
                });
                alumnDAO.close();
            }
        }).start();
    }

    public void saveAlumn(final String name, final String lastname, final Character gender){
        new Thread(new Runnable() {
            @Override
            public void run() {
                alumnDAO.open();
                alumnDAO.save(new Alumn(name, lastname, gender));
                alumnDAO.close();
                ((Activity)callback).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onCreatedAlumn();
                    }
                });
            }
        }).start();
    }

}
