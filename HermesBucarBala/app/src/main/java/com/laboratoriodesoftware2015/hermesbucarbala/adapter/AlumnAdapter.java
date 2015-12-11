package com.laboratoriodesoftware2015.hermesbucarbala.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Alumn;

import java.util.List;

/**
 * Created by AGUSTIN.BALA on 10-12-15.
 */
public class AlumnAdapter extends RecyclerView.Adapter<AlumnAdapter.AlumnViewHolder>{

    List<Alumn> alumns;

    public AlumnAdapter(List<Alumn> alumnList){
        this.alumns = alumnList;
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

        public AlumnViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
        }
    }
}
