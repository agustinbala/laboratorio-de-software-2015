package com.laboratoriodesoftware2015.hermesbucarbala.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.laboratoriodesoftware2015.hermesbucarbala.domain.Tab;
import com.laboratoriodesoftware2015.hermesbucarbala.fragment.PlaceholderFragment;

import java.util.List;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class TabPagerAdapter  extends FragmentPagerAdapter {

        private List<Tab> tabList;

        public TabPagerAdapter(FragmentManager fm, List<Tab> tabList) {
            super(fm);
            this.tabList = tabList;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(this.tabList.get(position).getName());
        }

        @Override
        public int getCount() {
            return this.tabList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
           return this.tabList.get(position).getName();
        }
}
