package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnPictogramDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.PictogramDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.TabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnPictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class TabPresenter {

    private PictogramDAO pictogramDAO;
    private TabDAO tabDAO;
    private AlumnPictogramDAO alumnPictogramDAO;

    public TabPresenter(){
        super();
        this.pictogramDAO = new PictogramDAO();
        this.tabDAO = new TabDAO();
        this.alumnPictogramDAO = new AlumnPictogramDAO();
    }

    public List<Pictogram> getPictogramsByTab(Integer tabId){
        pictogramDAO.open();
        List<Pictogram> list = pictogramDAO.listAll();
        pictogramDAO.close();
        tabDAO.open();
        Tab tab = tabDAO.getById(tabId);
        tabDAO.close();
        List<Pictogram> result = new ArrayList<Pictogram>();
        for (Pictogram pictogram : list){
            if(pictogram.getFolder().equals(tab.getName())){
                result.add(pictogram);
            }
        }
        return result;
    }

    public List<Pictogram> getPictogramsByTabAndAlumn(Integer tabId, Integer alumnId){
        alumnPictogramDAO.open();
        List<AlumnPictogram> alumnPictogramList = alumnPictogramDAO.listAllByAlumn(alumnId);
        alumnPictogramDAO.close();
        tabDAO.open();
        Tab tab = tabDAO.getById(tabId);
        tabDAO.close();
        List<Pictogram> result = new ArrayList<Pictogram>();
        pictogramDAO.open();
        for (AlumnPictogram alumnPictogram : alumnPictogramList){
            Pictogram pic = pictogramDAO.getById(alumnPictogram.getPictogramId());
            if(pic != null && pic.getFolder().equals(tab.getName())){
                result.add(pic);
            }
        }
        pictogramDAO.close();
        return result;

    }

    public List<Pictogram> getPictogramsByAlumn(Integer alumnId){
        alumnPictogramDAO.open();
        List<AlumnPictogram> alumnPictogramList = alumnPictogramDAO.listAllByAlumn(alumnId);
        alumnPictogramDAO.close();
        List<Pictogram> result = new ArrayList<Pictogram>();
        pictogramDAO.open();
        for (AlumnPictogram alumnPictogram : alumnPictogramList){
            Pictogram pic = pictogramDAO.getById(alumnPictogram.getPictogramId());
            if(pic != null){
                result.add(pic);
            }
        }
        pictogramDAO.close();
        return result;
    }
}
