package com.laboratoriodesoftware2015.hermesbucarbala.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.activity.ConfigurationActivity;
import com.laboratoriodesoftware2015.hermesbucarbala.activity.TabActivity;
import com.laboratoriodesoftware2015.hermesbucarbala.application.HermesApplication;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;

import java.util.List;

/**
 * Created by AGUSTIN.BALA on 10-12-15.
 */
public class AlumnAdapter extends RecyclerView.Adapter<AlumnAdapter.AlumnViewHolder>{

    List<Alumn> alumns;
    Activity context;
    private static final String ALUMN_ID = "ALUMN_ID";
    public AlumnAdapter(List<Alumn> alumnList, Activity context){
        this.alumns = alumnList;
        this.context = context;
    }
    @Override
    public AlumnViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alumn_item, parent, false);
        AlumnViewHolder pvh = new AlumnViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(AlumnViewHolder holder, int position) {
        holder.tvName.setText(alumns.get(position).getName() + " " + alumns.get(position).getLastname());
        holder.setAlumnId(alumns.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return alumns.size();
    }

    public void setAlumns(List<Alumn> alumnList){
        this.alumns = alumnList;
        notifyDataSetChanged();
    }

    public class AlumnViewHolder extends RecyclerView.ViewHolder  {

        TextView tvName;
        long id;

        public AlumnViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt(ALUMN_ID, (int) id);
                    editor.commit();
                    Intent intent= new Intent(AlumnAdapter.this.context, TabActivity.class);
                    AlumnAdapter.this.context.startActivity(intent);
                }
            });
        }

        private void setAlumnId(long id){
            this.id = id;
        }
    }
}
