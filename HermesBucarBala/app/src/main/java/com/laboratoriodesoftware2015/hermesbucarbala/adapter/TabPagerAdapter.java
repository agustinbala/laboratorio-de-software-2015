package com.laboratoriodesoftware2015.hermesbucarbala.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;


import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;
import com.laboratoriodesoftware2015.hermesbucarbala.fragment.PlaceholderFragment;

import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabPagerAdapter  extends FragmentStatePagerAdapter {

        private List<Tab> tabList;
        private boolean alumnMode;
        private Integer alumnId;
        private String alumnName;

        public TabPagerAdapter(FragmentManager fm, List<Tab> tabList, Boolean alumnMode, Integer alumnId, String alumnName) {
            super(fm);
            this.tabList = tabList;
            this.alumnMode = alumnMode;
            this.alumnId = alumnId;
            this.alumnName = alumnName;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position == 0) {
                return PlaceholderFragment.newInstance(-1, alumnMode, alumnId);
            } else {
                return PlaceholderFragment.newInstance(this.tabList.get(position - 1).getId(), alumnMode, alumnId);
            }
        }

        @Override
        public int getCount() {
            return this.tabList.size() + 1;
        }

        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return alumnName;
            }
           return this.tabList.get(position - 1).getName();
        }

     public void setList(List<Tab> tabList){
         this.tabList = tabList;
         notifyDataSetChanged();
     }
}
