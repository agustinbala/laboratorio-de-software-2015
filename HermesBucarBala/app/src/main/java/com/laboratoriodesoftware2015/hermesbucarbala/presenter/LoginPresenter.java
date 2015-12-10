package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import android.app.Activity;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.db.HermesSQLiteOpenHelper;
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


}
