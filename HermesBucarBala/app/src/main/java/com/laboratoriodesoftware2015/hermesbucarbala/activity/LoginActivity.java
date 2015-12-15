package com.laboratoriodesoftware2015.hermesbucarbala.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.adapter.AlumnAdapter;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.LoginPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.util.AudioUtil;
import com.laboratoriodesoftware2015.hermesbucarbala.view.LoginView;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter presenter;

    private RecyclerView recyclerView;
    private AlumnAdapter alumnAdapter;

    private FloatingActionButton newStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LoginPresenter(this);

        setContentView(R.layout.activity_login);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // custom dialog
                final Dialog dialog = new Dialog(LoginActivity.this);
                dialog.setContentView(R.layout.alumn_new_dialog);
                dialog.setTitle("NUEV@ ALUMN@");

                final EditText etName = (EditText) dialog.findViewById(R.id.et_name);
                final EditText etLastname = (EditText) dialog.findViewById(R.id.et_lastname);
                final RadioButton rb_male = (RadioButton) dialog.findViewById(R.id.radio_gender_male);
                final RadioButton rb_female = (RadioButton) dialog.findViewById(R.id.radio_gender_female);
                final RadioButton rb_size_small = (RadioButton) dialog.findViewById(R.id.radio_size_small);
                final RadioButton rb_size_medium = (RadioButton) dialog.findViewById(R.id.radio_size_medium);
                final RadioButton rb_size_big= (RadioButton) dialog.findViewById(R.id.radio_size_big);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(etName.getText().length() > 0 && etLastname.getText().length() > 0 &&
                                (rb_male.isChecked() || rb_female.isChecked()) &&
                                (rb_size_small.isChecked() || rb_size_medium.isChecked() || rb_size_big.isChecked())) {
                            Character gender = (rb_male.isChecked()) ? 'M' : 'F';
                            String size= (rb_size_small.isChecked()) ? Alumn.SIZE_SMALL : (rb_size_big.isChecked()) ? Alumn.SIZE_BIG: Alumn.SIZE_MEDIUM;
                            presenter.saveAlumn(etName.getText().toString(), etLastname.getText().toString(),gender, size);
                            dialog.dismiss();
                        } else {
                            Toast.makeText(LoginActivity.this, "Complete todos los campos", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                Button dialogButtonCancel = (Button) dialog.findViewById(R.id.dialogButtonCancel);
                dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        FloatingActionButton settings = (FloatingActionButton) findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, ConfigurationActivity.class);
                startActivity(intent);

            }});

                recyclerView = (RecyclerView) findViewById(R.id.rv);
                recyclerView.setHasFixedSize(true);
                LinearLayoutManager llm = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(llm);
                alumnAdapter = new AlumnAdapter(new ArrayList<Alumn>(), this);
                recyclerView.setAdapter(alumnAdapter);
                presenter.getAlumns();
            }

            @Override
            public void onListAlumns(List<Alumn> alumnList) {
                alumnAdapter.setAlumns(alumnList);
            }

            @Override
            public void onCreatedAlumn() {
                presenter.getAlumns();
            }
        }
