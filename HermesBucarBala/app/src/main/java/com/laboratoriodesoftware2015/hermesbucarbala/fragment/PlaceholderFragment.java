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
import java.util.List;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class PlaceholderFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    private TabPresenter presenter;
    private TabFragmentAdapter tabAdapter;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(String tabName) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SECTION_NUMBER, tabName);
        fragment.setArguments(args);

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tab, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        textView.setText(getArguments().getString(ARG_SECTION_NUMBER));
        RecyclerView pictureContainer = (RecyclerView) rootView.findViewById(R.id.container);
        pictureContainer.setHasFixedSize(true);
        StaggeredGridLayoutManager gridLayoutManager =
                new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        pictureContainer.setLayoutManager(gridLayoutManager);
        this.presenter = new TabPresenter();
        List<Pictogram> list = this.presenter.getPictogramsByTab(getArguments().getString(ARG_SECTION_NUMBER));
        tabAdapter = new TabFragmentAdapter(list, getActivity());
        pictureContainer.setAdapter(tabAdapter);
        return rootView;
    }
}