package com.laboratoriodesoftware2015.hermesbucarbala.adapter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.TabPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.util.AudioUtil;
import com.laboratoriodesoftware2015.hermesbucarbala.view.DashboardView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by natalia on 13/12/15.
 */
public class TabFragmentAdapter extends RecyclerView.Adapter<TabFragmentAdapter.TabFragmentViewHolder>{

    List<Pictogram> pictograms;
    Activity context;
    private Boolean isAlumnMode;
    private Integer tabId;
    private List<Pictogram> selectedPictograms;

    public TabFragmentAdapter(List<Pictogram> pictogramList, Activity context,  Boolean alumnMode, Integer tabId, List<Pictogram> selectedPictograms){
        this.pictograms = pictogramList;
        this.context = context;
        this.isAlumnMode= alumnMode;
        this.tabId = tabId;
        this.selectedPictograms = selectedPictograms;
    }

    @Override
    public TabFragmentAdapter.TabFragmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pictogram_item, parent, false);
        TabFragmentViewHolder tvh = new TabFragmentViewHolder(v);
        return tvh;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onBindViewHolder(final TabFragmentAdapter.TabFragmentViewHolder holder, final int position) {
        try (InputStream ims = context.getAssets().open(pictograms.get(position).getFolder()+"/"+pictograms.get(position).getName()+".png")) {
            Drawable d = Drawable.createFromStream(ims, null);
            holder.imPicture.setImageDrawable(d);
            if(tabId == -1){
                if(isAlumnMode) {
                    holder.imPicture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //TODO SENT TO MONITOR
                            final Dialog dialog = new Dialog(context);
                            dialog.setContentView(R.layout.pictogram_image_dialog);
                            dialog.setTitle(pictograms.get(position).getName());
                            final ImageView imageView = (ImageView) dialog.findViewById(R.id.image_tab_container);
                            try (InputStream ims = context.getAssets().open(pictograms.get(position).getFolder()+"/"+pictograms.get(position).getName()+".png")) {
                                Drawable d = Drawable.createFromStream(ims, null);
                                imageView.setImageDrawable(d);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dialog.show();
                            AudioUtil.reproduce(context, pictograms.get(position).getFolder() + "/" + pictograms.get(position).getName() + ".m4a");
                        }
                    });
                    holder.imPicture.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            ((DashboardView) context).deletePictogram(pictograms.get(position).getId());
                            return true;
                        }
                    });
                } else {
                    holder.imPicture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((DashboardView) context).deletePictogram(pictograms.get(position).getId());
                        }
                    });
                    holder.imPicture.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            ((DashboardView) context).deletePictogram(pictograms.get(position).getId());
                            return true;
                        }
                    });
                }
            } else {
                if(isAlumnMode) {
                    holder.imPicture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //TODO SENT TO MONITOR
                            final Dialog dialog = new Dialog(context);
                            dialog.setContentView(R.layout.pictogram_image_dialog);
                            dialog.setTitle(pictograms.get(position).getName());
                            final ImageView imageView = (ImageView) dialog.findViewById(R.id.image_tab_container);
                            try (InputStream ims = context.getAssets().open(pictograms.get(position).getFolder()+"/"+pictograms.get(position).getName()+".png")) {
                                Drawable d = Drawable.createFromStream(ims, null);
                                imageView.setImageDrawable(d);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dialog.show();
                            AudioUtil.reproduce(context, pictograms.get(position).getFolder()+"/"+pictograms.get(position).getName()+".m4a");
                        }
                    });
                    holder.imPicture.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            ((DashboardView) context).deletePictogram(pictograms.get(position).getId());
                            return true;
                        }
                    });
                } else {
                    Boolean isSelected = false;
                    for (Pictogram pic : selectedPictograms) {
                        if(pic.getId() == pictograms.get(position).getId()){
                            isSelected = true;
                        }
                    }
                    holder.pictureContainer.setSelected(isSelected);
                    holder.imPicture.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((DashboardView) context).addOrDeletePictogram(pictograms.get(position).getId());
                        }
                    });
                    holder.imPicture.setOnLongClickListener(null);
                }
            }
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
        LinearLayout pictureContainer;

        public TabFragmentViewHolder(View itemView) {
            super(itemView);
            imPicture = (ImageView) itemView.findViewById(R.id.image_tab_container);
            pictureContainer = (LinearLayout) itemView.findViewById(R.id.ll_image_tab_container);

        }
    }


}
