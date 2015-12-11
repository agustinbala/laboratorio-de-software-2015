package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import android.app.Activity;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.db.HermesSQLiteOpenHelper;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.view.LoginView;

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
        alumnDAO.open();
        callback.onListAlumns(alumnDAO.listAll());
        alumnDAO.close();
    }

    public void saveAlumn(String name, String lastname){
        alumnDAO.open();
        alumnDAO.save(new Alumn(name,lastname));
        alumnDAO.close();
    }

}
