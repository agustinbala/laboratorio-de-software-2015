package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.dao.AlumnDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.dao.ConfigurationDAO;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.view.ConfigurationView;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationPresenter {

    private AlumnDAO alumnDAO;
    private ConfigurationDAO configurationDAO;
    private ConfigurationView callback;

    public ConfigurationPresenter(ConfigurationView activity){
        this.callback = activity;
        configurationDAO = new ConfigurationDAO();
        alumnDAO = new AlumnDAO();
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


}
