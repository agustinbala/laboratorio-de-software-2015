package com.laboratoriodesoftware2015.hermesbucarbala.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by natalia on 13/12/15.
 */
public class TabFragmentAdapter extends RecyclerView.Adapter<TabFragmentAdapter.TabFragmentViewHolder>{

    List<Pictogram> pictograms;
    Activity context;

    public TabFragmentAdapter(List<Pictogram> pictogramList, Activity context){
        this.pictograms = pictogramList;
        this.context = context;
    }

    @Override
    public TabFragmentAdapter.TabFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pictogram_item, parent, false);
        TabFragmentViewHolder tvh = new TabFragmentViewHolder(v);
        return tvh;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(TabFragmentAdapter.TabFragmentViewHolder holder, int position) {
        try (InputStream ims = context.getAssets().open(pictograms.get(position).getFolder()+"/"+pictograms.get(position).getName()+".png")) {
            Drawable d = Drawable.createFromStream(ims, null);
            holder.imPicture.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return pictograms.size();
    }

    public class TabFragmentViewHolder extends RecyclerView.ViewHolder  {

        ImageView imPicture;

        public TabFragmentViewHolder(View itemView) {
            super(itemView);
            imPicture = (ImageView) itemView.findViewById(R.id.image_tab_container);

        }
    }
}
