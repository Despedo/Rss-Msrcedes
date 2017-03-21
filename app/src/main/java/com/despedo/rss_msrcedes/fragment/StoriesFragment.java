package com.despedo.rss_msrcedes.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.despedo.rss_msrcedes.R;
import com.despedo.rss_msrcedes.adapter.NewsListAdapter;
import com.despedo.rss_msrcedes.dto.NewsDTO;

import java.util.List;

public class StoriesFragment extends AbstractFragment {
    private static final int LAYOUT = R.layout.fragment_stories;
    private List<NewsDTO> data;
    private NewsListAdapter newsListAdapter;

    public static StoriesFragment getInstance(Context context, List<NewsDTO> data) {
        Bundle args = new Bundle();
        StoriesFragment fragment = new StoriesFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.stories));
        fragment.setData(data);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleViewStories);
        rv.setLayoutManager(new LinearLayoutManager(context));
        newsListAdapter = new NewsListAdapter(data);
        rv.setAdapter(newsListAdapter);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<NewsDTO> data) {
        this.data = data;
    }

    public void refreshData(List<NewsDTO> data) {
        newsListAdapter.setData(data);
        newsListAdapter.notifyDataSetChanged();
    }
}
