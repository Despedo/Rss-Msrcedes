package com.despedo.rss_msrcedes.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.despedo.rss_msrcedes.NewsHolder;
import com.despedo.rss_msrcedes.fragment.AbstractFragment;
import com.despedo.rss_msrcedes.fragment.FavouritesFragment;
import com.despedo.rss_msrcedes.fragment.StoriesFragment;
import com.despedo.rss_msrcedes.fragment.VideoFragment;

import java.util.HashMap;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractFragment> tabs;
    private Context context;

    private StoriesFragment storiesFragment;
    private VideoFragment videoFragment;
    private FavouritesFragment favouritesFragment;


    public TabsFragmentAdapter(Context context, FragmentManager fm) {
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
        storiesFragment = StoriesFragment.getInstance(context);
        videoFragment = VideoFragment.getInstance(context);
        favouritesFragment = FavouritesFragment.getInstance(context);

        tabs.put(0, storiesFragment);
        tabs.put(1, favouritesFragment);
        tabs.put(2, videoFragment);
    }

    public void refreshFragmentsData() {
        storiesFragment.refreshData(NewsHolder.getData());
    }
}
