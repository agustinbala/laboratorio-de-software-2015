package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.PictogramDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.TabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
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

    public void sendNotification(Integer idPicture, Integer idAlumn){
        Alumn alumn;
        Pictogram pictogram;
        alumn = getAlumn(idAlumn);
        pictogram = getPictogram(idPicture);
        service = new RestApiImpl();

        service.sendNotification(pictogram.getName(), pictogram.getFolder(), alumn.getName());
    }

    private Pictogram getPictogram(Integer idPicture) {
        Pictogram pictogram;
        pictogramDAO = new PictogramDAO();
        pictogramDAO.open();
        pictogram =pictogramDAO.getById(idPicture);
        pictogramDAO.close();
        return pictogram;
    }


    private Alumn getAlumn(Integer id) {
        Alumn alumn;
        alumnDao = new AlumnDAO();
        alumnDao.open();
        alumn = alumnDao.getById(id);
        alumnDao.close();
        return alumn;

    }
}
