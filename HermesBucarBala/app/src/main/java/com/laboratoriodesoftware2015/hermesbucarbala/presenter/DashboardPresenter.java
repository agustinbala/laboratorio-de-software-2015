package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnPictogramDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.TabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnPictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;

import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class DashboardPresenter {

    private TabDAO tabDAO;
    private AlumnDAO alumnDAO;
    private AlumnPictogramDAO alumnPictogramDAO;

    public DashboardPresenter(){
        super();
        this.tabDAO = new TabDAO();
        this.alumnDAO = new AlumnDAO();
        this.alumnPictogramDAO = new AlumnPictogramDAO();
    }

    public List<Tab> getListTabs(){
        tabDAO.open();
        List<Tab> tabs = tabDAO.listAll();
        tabDAO.close();
        return tabs;
    }

    public List<Tab> getListTabsById(Long idAlumn) {
        Alumn alumn = new Alumn();
        alumnDAO.open();
        alumn = alumnDAO.getById(idAlumn);
        alumnDAO.close();
        return alumn.getTabs();
    }

    public String getAlumnName(Integer idAlumn){
        Alumn alumn = new Alumn();
        alumnDAO.open();
        alumn = alumnDAO.getById(idAlumn);
        alumnDAO.close();
        return alumn.getName();
    }

    public String getAlumnPictureSize(Integer idAlumn){
        Alumn alumn = new Alumn();
        alumnDAO.open();
        alumn = alumnDAO.getById(idAlumn);
        alumnDAO.close();
        return alumn.getSize();
    }

    public void deletePictogram(Integer idAlumn, Integer idPictogram){
        alumnPictogramDAO.open();
        alumnPictogramDAO.delete(new AlumnPictogram(idAlumn, idPictogram));
        alumnPictogramDAO.close();
    }

    public void savePictogram(Integer idAlumn, Integer idPictogram){
        alumnPictogramDAO.open();
        alumnPictogramDAO.save(new AlumnPictogram(idAlumn, idPictogram));
        alumnPictogramDAO.close();
    }

    public AlumnPictogram getAlumnPictogram(Integer idAlumn, Integer idPictogram){
        alumnPictogramDAO.open();
        AlumnPictogram alumnPictogram = alumnPictogramDAO.get(idAlumn, idPictogram);
        alumnPictogramDAO.close();
        return alumnPictogram;
    }
}
