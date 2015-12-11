package com.laboratoriodesoftware2015.hermesbucarbala.presenter;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationPresenter {

    private Alumn alumn;
    private Configuration configuration;

    public ConfigurationPresenter(){
         alumn = new Alumn();
        alumn.setName("Agustin");
        alumn.setLastname("Bala");
        alumn.setGender('M');
        alumn.setSize("Mediano");
        configuration = new Configuration();
        configuration.setPort("800");
        configuration.setServer("http://localhost");
    }

    public Alumn getAlumn(){
        return alumn;
    }

    public Configuration getConfiguration(){
        return configuration;
    }


}
