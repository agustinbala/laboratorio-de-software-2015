package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnTabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.ConfigurationDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.TabDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnTab;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;
import com.laboratoriodesoftware2015.hermesbucarbala.view.ConfigurationView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationPresenter {

    private AlumnDAO alumnDAO;
    private ConfigurationDAO configurationDAO;
    private TabDAO tabDAO;
    private AlumnTabDAO alumnTabDAO;
    private ConfigurationView callback;

    public ConfigurationPresenter(ConfigurationView activity){
        this.callback = activity;
        configurationDAO = new ConfigurationDAO();
        alumnDAO = new AlumnDAO();
        tabDAO = new TabDAO();
        alumnTabDAO = new AlumnTabDAO();
    }

    public Alumn getAlumn(long id){
        Alumn alumn;
        alumnDAO.open();
        alumn = alumnDAO.getById(id);
        alumnDAO.close();
        return alumn;
    }

    public Configuration getConfiguration(){
        Configuration configuration;
        configurationDAO.open();
        configuration = configurationDAO.get();
        configurationDAO.close();
        return configuration;
    }

    public void setConfiguration(String server, String port){
        Configuration configuration = new Configuration(server, port);
        configurationDAO.open();
        configurationDAO.save(configuration);
        configurationDAO.close();
        callback.onUpdateConfiguration(configuration);
    }

    public void updateConfiguration(String server, String port, long id){
        Configuration conf = new Configuration(server, port);
        conf.setId(id);
        configurationDAO.open();
        configurationDAO.update(conf);
        configurationDAO.close();
        callback.onUpdateConfiguration(conf);
    }


    public void updateTab(String tabName, Alumn alumn) {
        for ( Tab tab: this.listTabs()) {
            if(tabName.equals(tab.getName())){
                alumnTabDAO.open();
                AlumnTab alumnTab = new AlumnTab(alumn.getId(), tab.getId());
                alumnTabDAO.save(alumnTab);
                alumnTabDAO.close();
            }
        }
    }

    public void deleteTab(String tabName , Alumn alumn) {
        for ( Tab tab: this.listTabs()) {
            if(tabName.equals(tab.getName())){
                alumnTabDAO.open();
                AlumnTab alumnTab = new AlumnTab(alumn.getId(), tab.getId());
                alumnTabDAO.delete(alumnTab);
                alumnTabDAO.close();
            }
        }
    }

    private List<Tab> listTabs(){
        List<Tab> tabs = new ArrayList<Tab>();
        tabDAO.open();
        tabs = tabDAO.listAll();
        tabDAO.close();
        return tabs;
    }
}
