package com.despedo.rss_msrcedes.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.despedo.rss_msrcedes.R;
import com.despedo.rss_msrcedes.fragment.ExampleFragment;

/**
 * Created by Despedo on 19.03.2017.
 */

public class TabsAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabs = new String[]{
                context.getResources().getString(R.string.stories),
                context.getResources().getString(R.string.video),
                context.getResources().getString(R.string.favourites)
        };
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return ExampleFragment.getInstance();
            case 1: return ExampleFragment.getInstance();
            case 2: return ExampleFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
