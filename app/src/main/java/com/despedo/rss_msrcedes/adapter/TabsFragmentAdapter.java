package com.despedo.rss_msrcedes.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.despedo.rss_msrcedes.fragment.AbstractFragment;
import com.despedo.rss_msrcedes.fragment.FavouritesFragment;
import com.despedo.rss_msrcedes.fragment.StoriesFragment;
import com.despedo.rss_msrcedes.fragment.VideoFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Despedo on 19.03.2017.
 */

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractFragment> tabs;
    private Context context;

    public TabsFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        initTabsMap();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap() {
        tabs = new HashMap<>();
        tabs.put(0, StoriesFragment.getInstance(context));
        tabs.put(1, VideoFragment.getInstance(context));
        tabs.put(2, FavouritesFragment.getInstance(context));
    }
}
