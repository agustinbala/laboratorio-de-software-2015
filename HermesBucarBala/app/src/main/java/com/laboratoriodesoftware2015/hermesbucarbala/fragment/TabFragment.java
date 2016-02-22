package com.laboratoriodesoftware2015.hermesbucarbala.fragment;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.adapter.TabFragmentAdapter;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.AlumnPictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.TabPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.util.AudioUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class TabFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_TAB_ID = "tab_id";
    private static final String ARG_ALUMN_ID = "alumn_id";
    private static final String ARG_ALUMN_MODE = "alumn_mode";
    private static final String PICTURE_SIZE = "picture_size";

    private TabPresenter presenter;
    private TabFragmentAdapter tabAdapter;
    private List<Pictogram> list;
    private LinearLayout yes;
    private LinearLayout no;


    public TabFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TabFragment newInstance(Integer tabId, Boolean alumnMode, Integer alumnId, String pictureSize) {
        TabFragment fragment = new TabFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB_ID, tabId);
        args.putInt(ARG_ALUMN_ID, alumnId);
        args.putBoolean(ARG_ALUMN_MODE, alumnMode);
        args.putString(PICTURE_SIZE, pictureSize);
        fragment.setArguments(args);

        return fragment;
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        Boolean isAlumnMode = getArguments().getBoolean(ARG_ALUMN_MODE);
        Integer alumnId = getArguments().getInt(ARG_ALUMN_ID);
        Integer tabId = getArguments().getInt(ARG_TAB_ID);
        String pictureSize = getArguments().getString(PICTURE_SIZE);
        yes = (LinearLayout) rootView.findViewById(R.id.si);
        no = (LinearLayout) rootView.findViewById(R.id.no);
        LinearLayout afirmativeContainer = (LinearLayout) rootView.findViewById(R.id.afirmative);
        try (InputStream imsSi = getActivity().getAssets().open("si.png")) {
            Drawable dsi = Drawable.createFromStream(imsSi, null);
            yes.setBackground(dsi);
        } catch (IOException e) {
            e.printStackTrace();
        }
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageDialog("si.png", "si.m4a", "si");
            }
        });
        try (InputStream imsNo = getActivity().getAssets().open("no.png")) {
            Drawable dno = Drawable.createFromStream(imsNo, null);
            no.setBackground(dno);
        } catch (IOException e) {
            e.printStackTrace();
        }
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageDialog("no.png", "no.m4a", "no");
            }
        });
        RecyclerView pictureContainer = (RecyclerView) rootView.findViewById(R.id.container);
        pictureContainer.setHasFixedSize(true);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        pictureContainer.setLayoutManager(gridLayoutManager);
        this.presenter = new TabPresenter();
        List<Pictogram> alumnPictograms = new ArrayList<>();
        if(tabId == -1){
            list = this.presenter.getPictogramsByAlumn(alumnId);
            if(!isAlumnMode){
                afirmativeContainer.setVisibility(View.GONE);
            }else{
                afirmativeContainer.setVisibility(View.VISIBLE);
            }
        } else {
            if (!isAlumnMode) {
                list = this.presenter.getPictogramsByTab(getArguments().getInt(ARG_TAB_ID));
                alumnPictograms = this.presenter.getPictogramsByAlumn(alumnId);
                afirmativeContainer.setVisibility(View.GONE);
            } else {
                list = this.presenter.getPictogramsByTab(getArguments().getInt(ARG_TAB_ID));
                afirmativeContainer.setVisibility(View.VISIBLE);
            }
        }
        tabAdapter = new TabFragmentAdapter(list, getActivity(), isAlumnMode, tabId,alumnPictograms,  pictureSize);
        pictureContainer.setAdapter(tabAdapter);
        return rootView;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void imageDialog(String asset, String audio, String name){

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.pictogram_image_dialog);
        dialog.setTitle(name);
        final LinearLayout imageView = (LinearLayout) dialog.findViewById(R.id.image_tab_container);
        try (InputStream ims = getActivity().getAssets().open(asset)) {
            Drawable d = Drawable.createFromStream(ims, null);
            imageView.setBackground(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dialog.show();
        AudioUtil.reproduce(getActivity(), audio);

    }
}