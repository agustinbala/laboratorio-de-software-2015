package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.PictogramDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class TabPresenter {

    private PictogramDAO pictogramDAO;

    public TabPresenter(){
        super();
        this.pictogramDAO = new PictogramDAO();
    }

    public List<Pictogram> getPictogramsByTab(String tabName){
        pictogramDAO.open();
        List<Pictogram> list = pictogramDAO.listAll();
        pictogramDAO.close();
        List<Pictogram> result = new ArrayList<Pictogram>();
        for (Pictogram pictogram : list){
            if(pictogram.getFolder().equals(tabName)){
                result.add(pictogram);
            }
        }
        return result;
    }
}
