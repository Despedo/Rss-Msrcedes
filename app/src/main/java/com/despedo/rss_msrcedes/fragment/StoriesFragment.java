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

import java.util.ArrayList;
import java.util.List;

public class StoriesFragment extends AbstractFragment{
    private static final int LAYOUT = R.layout.fragment_stories;

    public static StoriesFragment getInstance(Context context){
        Bundle args = new Bundle();
        StoriesFragment fragment = new StoriesFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.stories));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);


        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycleView);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new NewsListAdapter(mock()));

        return view;
    }


    private List<NewsDTO> mock(){
        List<NewsDTO> data = new ArrayList<>();
        data.add(new NewsDTO("id 1", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 2", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 3", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 4", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 5", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 6", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 7", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 8", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 9", "Link", "name", "description", "cover", "top", "createdAt"));
        data.add(new NewsDTO("id 10", "Link", "name", "description", "cover", "top", "createdAt"));

        return data;
    }

    public void setContext(Context context) {
        this.context = context;
    }


}
