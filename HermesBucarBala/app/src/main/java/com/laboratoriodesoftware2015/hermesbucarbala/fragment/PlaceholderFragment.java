package com.laboratoriodesoftware2015.hermesbucarbala.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Pictogram;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.TabPresenter;

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
        this.presenter = new TabPresenter();
        List<Pictogram> list = this.presenter.getPictogramsByTab(getArguments().getString(ARG_SECTION_NUMBER));
        for (Pictogram pic: list){
            TextView tv = new TextView(getActivity());
            tv.setText(pic.getName()+"     ");
            ((ViewGroup)rootView).addView(tv);
        }
        return rootView;
    }
}