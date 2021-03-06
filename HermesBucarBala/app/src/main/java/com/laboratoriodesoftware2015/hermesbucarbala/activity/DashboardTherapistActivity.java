package com.laboratoriodesoftware2015.hermesbucarbala.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.laboratoriodesoftware2015.hermesbucarbala.R;
import com.laboratoriodesoftware2015.hermesbucarbala.adapter.TabPagerAdapter;
import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;
import com.laboratoriodesoftware2015.hermesbucarbala.presenter.DashboardPresenter;
import com.laboratoriodesoftware2015.hermesbucarbala.view.DashboardView;
import com.laboratoriodesoftware2015.hermesbucarbala.view.SlidingTabLayout;

import java.util.List;

public class DashboardTherapistActivity extends AppCompatActivity implements DashboardView {

    /**
     * The {@link PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link TabPagerAdapter}.
     */
    private TabPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private SlidingTabLayout mSlidingTabLayout;

    private DashboardPresenter presenter;


    private int idAlumn;

    private static final String MODE_ALUMN = "MODE_ALUMN";
    private static final String ALUMN_ID = "ALUMN_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        idAlumn =  sharedPref.getInt(ALUMN_ID, 0);
        this.presenter = new DashboardPresenter();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        List<Tab> listTab = this.presenter.getListTabs();

        mSectionsPagerAdapter = new TabPagerAdapter(getFragmentManager(),  listTab, false, idAlumn, this.presenter.getAlumnName(idAlumn), this.presenter.getAlumnPictureSize(idAlumn));
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.pager_header);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(mViewPager);

    }



    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
         getMenuInflater().inflate(R.menu.menu_tab_alumn, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(DashboardTherapistActivity.this, ConfigurationActivity.class);
            startActivity(intent);
        }

       if (id == R.id.action_student) {
            SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean(MODE_ALUMN, true);
            editor.commit();
            Intent intent= new Intent(DashboardTherapistActivity.this,DashboardAlumnActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void deletePictogram(Integer pictogramId) {
        presenter.deletePictogram(idAlumn, pictogramId);
        updateView();
    }

    @Override
    public void addOrDeletePictogram(Integer pictogramId) {
        if(presenter.getAlumnPictogram(idAlumn,pictogramId) != null){
            presenter.deletePictogram(idAlumn,pictogramId);
        } else {
            presenter.savePictogram(idAlumn, pictogramId);
        }
       updateView();
    }

    @Override
    public void sendNotification(Integer pictogramId) {

    }

    @Override
    public void showConnetionError() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DashboardTherapistActivity.this, getString(R.string.connection_error_message), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateView(){
        Integer currentPosition = mSectionsPagerAdapter.getCurrentPosition();
        setTabs();
        mViewPager.setCurrentItem(currentPosition);
    }

    private void setTabs(){
        List<Tab> listTab = this.presenter.getListTabs();
        mSectionsPagerAdapter.setList(listTab);
    }

}
