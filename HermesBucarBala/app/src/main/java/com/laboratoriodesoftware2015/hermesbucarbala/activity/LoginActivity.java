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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.adapter.AlumnAdapter;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.LoginPresenter;
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

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.saveAlumn(etName.getText().toString(), etLastname.getText().toString());
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        newStudent = (FloatingActionButton) findViewById(R.id.new_student);
        newStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,ConfigurationActivity.class);
                startActivity(intent);
            }
        });

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
