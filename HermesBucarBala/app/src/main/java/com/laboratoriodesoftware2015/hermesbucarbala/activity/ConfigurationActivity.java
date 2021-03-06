package com.laboratoriodesoftware2015.hermesbucarbala.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Configuration;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.ConfigurationPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.view.ConfigurationView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by natalia on 10/12/15.
 */
public class ConfigurationActivity extends AppCompatActivity implements ConfigurationView, CompoundButton.OnCheckedChangeListener{

    private ConfigurationPresenter presenter;
    private TextView name;
    private TextView lastname;
    private TextView gender;
    private TextView size;
    private TextView port;
    private TextView ip;
    private FloatingActionButton editButton;
    private CheckBox pista;
    private CheckBox establo;
    private CheckBox necesidades;
    private CheckBox emociones;
    private Button deleteBtn;
    private long id;
    private Alumn alumn;
    private LinearLayout student;
    private static final String ALUMN_ID = "ALUMN_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);
        presenter = new ConfigurationPresenter(this);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        id = sharedPref.getInt(ALUMN_ID, 0);
        alumn = null;
        initView();

    }

    public void initView(){

        student = (LinearLayout) findViewById(R.id.configuration_student);
        name = (TextView) findViewById(R.id.student_name_content);
        lastname = (TextView) findViewById(R.id.student_last_name);
        gender = (TextView) findViewById(R.id.student_fame);
        size = (TextView) findViewById(R.id.student_picture);
        port= (TextView) findViewById(R.id.configuration_port_content);
        ip = (TextView) findViewById(R.id.configuration_ip_content);
        editButton = (FloatingActionButton) findViewById(R.id.new_configuration);
        pista = (CheckBox) findViewById(R.id.checkbox_pista);
        establo = (CheckBox) findViewById(R.id.checkbox_establo);
        necesidades = (CheckBox) findViewById(R.id.checkbox_necesidades);
        emociones = (CheckBox) findViewById(R.id.checkbox_emociones);
        deleteBtn = (Button) findViewById(R.id.btn_delete_alumn);
        if(id != 0) {
            alumn = presenter.getAlumn(id);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(ConfigurationActivity.this).setTitle(getString(R.string.delete_alumn_confirmation_title)).setMessage(getString(R.string.delete_alumn_confirmation_message))
                            .setCancelable(false).setPositiveButton(getString(R.string.dialog_confirmation_button_positive), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            presenter.deleteAlumn(alumn);
                            Intent intent = new Intent(ConfigurationActivity.this, LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            ConfigurationActivity.this.finish();
                        }
                    }).setNegativeButton(getString(R.string.dialog_confirmation_button_negative), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).show();


                }
            });
            deleteBtn.setVisibility(View.VISIBLE);
        } else {
            deleteBtn.setVisibility(View.GONE);
        }
        final Configuration conf = presenter.getConfiguration();
        if(alumn != null) {
            name.setText(alumn.getName());
            lastname.setText(alumn.getLastname());
            if(alumn.getGender() != null) {
                gender.setText(("M".equals(alumn.getGender()) ? getString(R.string.student_male_value) : getString( R.string.student_female_value)));
            }
            size.setText(alumn.getSize());
            if(alumn.getTabs() != null){
               setTabAlumn();
            }
        }else{
            student.setVisibility(View.GONE);
        }
        if(conf != null) {
            port.setText(conf.getPort());
            ip.setText(conf.getServer());
        }

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(ConfigurationActivity.this);
                dialog.setContentView(R.layout.configuration_new_dialog);
                dialog.setTitle(getString(R.string.action_settings));

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

        pista.setOnCheckedChangeListener(this);
        establo.setOnCheckedChangeListener(this);
        necesidades.setOnCheckedChangeListener(this);
        emociones.setOnCheckedChangeListener(this);

    }

    private void setTabAlumn() {
        for (Tab tab: alumn.getTabs()) {
            switch((int)tab.getId()){
                case 1:
                    establo.setChecked(true);
                    break;
                case 2:
                    pista.setChecked(true);
                    break;
                case 3:
                    necesidades.setChecked(true);
                    break;
                case 4:
                    emociones.setChecked(true);
                    break;
            }
        }
    }

    @Override
    public void onUpdateConfiguration(Configuration configuration) {
        port.setText(configuration.getPort());
        ip.setText(configuration.getServer());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            presenter.updateTab(buttonView.getText().toString(), alumn);
        }else{
            presenter.deleteTab(buttonView.getText().toString(), alumn);
        }
    }

}
