package com.laboratoriodesoftware2015.hermesbucarbala.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.ConfigurationPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.LoginPresenter;

import org.w3c.dom.Text;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationActivity extends AppCompatActivity{

    private ConfigurationPresenter presenter;
    private TextView name;
    private TextView lastname;
    private TextView gender;
    private TextView size;
    private TextView port;
    private TextView ip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        presenter = new ConfigurationPresenter();
        initView();

    }

    public void initView(){

        name = (TextView) findViewById(R.id.student_name_content);
        lastname = (TextView) findViewById(R.id.student_last_name);
        gender = (TextView) findViewById(R.id.student_fame);
        size = (TextView) findViewById(R.id.student_picture);
        port= (TextView) findViewById(R.id.configuration_port_content);
        ip = (TextView) findViewById(R.id.configuration_ip_content);
        Alumn alumn = presenter.getAlumn();
        Configuration conf = presenter.getConfiguration();
        name.setText(alumn.getName());
        lastname.setText(alumn.getLastname());
        gender.setText(alumn.getGender().toString());
        size.setText(alumn.getSize());
        port.setText(conf.getPort());
        ip.setText(conf.getServer());

    }

}
