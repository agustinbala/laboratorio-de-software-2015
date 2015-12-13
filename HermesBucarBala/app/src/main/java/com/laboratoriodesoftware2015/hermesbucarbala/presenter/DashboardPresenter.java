package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.TabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;

import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class DashboardPresenter {

    private TabDAO tabDAO;

    public DashboardPresenter(){
        super();
        this.tabDAO = new TabDAO();
    }

    public List<Tab> getListTabs(){
        tabDAO.open();
        List<Tab> tabs = tabDAO.listAll();
        tabDAO.close();
        return tabs;
    }
}
