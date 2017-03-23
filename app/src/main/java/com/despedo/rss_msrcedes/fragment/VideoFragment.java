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

public class VideoFragment extends AbstractFragment {
    private static final int LAYOUT = R.layout.fragment_video;

    public static VideoFragment getInstance(Context context) {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.video));

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(LAYOUT, container, false);

        return view;
    }

    public void setContext(Context context) {
        this.context = context;
    }

}
