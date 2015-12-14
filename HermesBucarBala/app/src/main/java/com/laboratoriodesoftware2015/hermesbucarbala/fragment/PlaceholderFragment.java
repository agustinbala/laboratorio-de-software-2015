package com.laboratoriodesoftware2015.hermesbucarbala.fragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.adapter.TabFragmentAdapter;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.TabPresenter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_TAB_ID = "tab_id";
    private static final String ARG_ALUMN_ID = "alumn_id";
    private static final String ARG_ALUMN_MODE = "alumn_mode";

    private TabPresenter presenter;
    private TabFragmentAdapter tabAdapter;
    private List<Pictogram> list;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(Integer tabId, Boolean alumnMode, Integer alumnId) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_TAB_ID, tabId);
        args.putInt(ARG_ALUMN_ID, alumnId);
        args.putBoolean(ARG_ALUMN_MODE,alumnMode);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        Boolean isAlumnMode = getArguments().getBoolean(ARG_ALUMN_MODE);
        Integer alumnId = getArguments().getInt(ARG_ALUMN_ID);
        Integer tabId = getArguments().getInt(ARG_TAB_ID);
        RecyclerView pictureContainer = (RecyclerView) rootView.findViewById(R.id.container);
        pictureContainer.setHasFixedSize(true);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        pictureContainer.setLayoutManager(gridLayoutManager);
        this.presenter = new TabPresenter();
        if(tabId == -1){
            list = this.presenter.getPictogramsByAlumn(alumnId);
        } else {
            if (!isAlumnMode) {
                list = this.presenter.getPictogramsByTab(getArguments().getInt(ARG_TAB_ID));
            } else {
                list = this.presenter.getPictogramsByTabAndAlumn(tabId, alumnId);
            }
        }
        tabAdapter = new TabFragmentAdapter(list, getActivity(), isAlumnMode,tabId );
        pictureContainer.setAdapter(tabAdapter);
        return rootView;
    }
}