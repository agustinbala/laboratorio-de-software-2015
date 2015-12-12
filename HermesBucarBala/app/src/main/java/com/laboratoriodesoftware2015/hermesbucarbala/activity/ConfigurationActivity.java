package com.laboratoriodesoftware2015.hermesbucarbala.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.ConfigurationPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.view.ConfigurationView;


import org.w3c.dom.Text;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationActivity extends AppCompatActivity implements ConfigurationView{

    private ConfigurationPresenter presenter;
    private TextView name;
    private TextView lastname;
    private TextView gender;
    private TextView size;
    private TextView port;
    private TextView ip;
    private FloatingActionButton editButton;
    private long id;
    private static final String ALUMN_ID = "ALUMN_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        presenter = new ConfigurationPresenter(this);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        long id = sharedPref.getInt(ALUMN_ID, 0);
        initView();

    }

    public void initView(){

        name = (TextView) findViewById(R.id.student_name_content);
        lastname = (TextView) findViewById(R.id.student_last_name);
        gender = (TextView) findViewById(R.id.student_fame);
        size = (TextView) findViewById(R.id.student_picture);
        port= (TextView) findViewById(R.id.configuration_port_content);
        ip = (TextView) findViewById(R.id.configuration_ip_content);
        editButton = (FloatingActionButton) findViewById(R.id.new_configuration);
        Alumn alumn = presenter.getAlumn(id);
        final Configuration conf = presenter.getConfiguration();
        if(alumn != null) {
            name.setText(alumn.getName());
            lastname.setText(alumn.getLastname());
        }
        //gender.setText(alumn.getGender().toString());
        //size.setText(alumn.getSize());
        if(conf != null) {
            port.setText(conf.getPort());
            ip.setText(conf.getServer());
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(ConfigurationActivity.this);
                dialog.setContentView(R.layout.configuration_new_dialog);
                dialog.setTitle("Configuracion Personal");

                final EditText etServer = (EditText) dialog.findViewById(R.id.et_ip);
                final EditText etPort = (EditText) dialog.findViewById(R.id.et_port);

                if (conf != null) {
                    etServer.setText(conf.getServer());
                    etPort.setText(conf.getPort());
                }

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogConfingOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (conf != null) {
                            presenter.updateConfiguration(etServer.getText().toString(), etPort.getText().toString(), conf.getId());
                        } else {
                            presenter.setConfiguration(etServer.getText().toString(), etPort.getText().toString());
                        }

                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }

    @Override
    public void onUpdateConfiguration(Configuration configuration) {
        port.setText(configuration.getPort());
        ip.setText(configuration.getServer());
    }
}
