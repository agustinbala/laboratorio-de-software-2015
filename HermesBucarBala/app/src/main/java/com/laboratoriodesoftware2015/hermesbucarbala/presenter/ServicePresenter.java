package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.ConfigurationDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.PictogramDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.TabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;
import com.laboratoriodesoftware2015.hermesbucarbala.service.RestApi;
import com.laboratoriodesoftware2015.hermesbucarbala.service.RestApiImpl;

/**
 * Created by natalia on 15/12/15.
 */
public class ServicePresenter {
    
    private RestApi service;
    private AlumnDAO alumnDao;
    private PictogramDAO pictogramDAO;
    private ConfigurationDAO configurationDAO;

    public ServicePresenter(){
        this.alumnDao = new AlumnDAO();
        this.service = new RestApiImpl();
        this.pictogramDAO = new PictogramDAO();
        this.configurationDAO = new ConfigurationDAO();
    }

    public void sendNotification(Integer idPicture, Integer idAlumn){
        final Alumn alumn = getAlumn(idAlumn);
        final Pictogram pictogram = getPictogram(idPicture);
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.sendNotification(pictogram.getName(), pictogram.getFolder(), alumn.getName(), getUrl());
            }}).start();
    }

    private Pictogram getPictogram(Integer idPicture) {
        pictogramDAO.open();
        Pictogram pictogram =pictogramDAO.getById(idPicture);
        pictogramDAO.close();
        return pictogram;
    }


    private Alumn getAlumn(Integer id) {
        alumnDao.open();
        Alumn alumn = alumnDao.getById(id);
        alumnDao.close();
        return alumn;
    }

    private String getUrl(){
        configurationDAO.open();
        Configuration configuration = configurationDAO.get();
        configurationDAO.close();
        if(configuration != null){
            return "http://"+configuration.getServer()+":"+configuration.getPort()+"/notification";
        }
        return "";
    }
}
