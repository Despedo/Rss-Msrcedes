package com.despedo.rss_msrcedes.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.despedo.rss_msrcedes.dto.NewsDTO;
import com.despedo.rss_msrcedes.fragment.AbstractFragment;
import com.despedo.rss_msrcedes.fragment.FavouritesFragment;
import com.despedo.rss_msrcedes.fragment.StoriesFragment;
import com.despedo.rss_msrcedes.fragment.VideoFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private Map<Integer, AbstractFragment> tabs;
    private Context context;

    private List<NewsDTO> data;

    private StoriesFragment storiesFragment;
    private VideoFragment videoFragment;
    private FavouritesFragment favouritesFragment;

    public void setData(List<NewsDTO> data) {
        this.data = data;
        storiesFragment.refreshData(data);
    }

    public TabsFragmentAdapter(Context context, FragmentManager fm, List<NewsDTO> data) {
        super(fm);
        this.data = data;
        this.context = context;
        initTabsMap(context);
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

    private void initTabsMap(Context context) {
        tabs = new HashMap<>();
        storiesFragment = StoriesFragment.getInstance(context, data);
        tabs.put(0, storiesFragment);
        videoFragment = VideoFragment.getInstance(context);
        tabs.put(1, videoFragment);
        favouritesFragment = FavouritesFragment.getInstance(context);
        tabs.put(2, favouritesFragment);
    }
}
