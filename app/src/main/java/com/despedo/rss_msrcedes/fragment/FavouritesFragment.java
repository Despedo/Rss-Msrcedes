package com.despedo.rss_msrcedes.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.despedo.rss_msrcedes.R;

public class FavouritesFragment extends AbstractFragment {
    private static final int LAYOUT = R.layout.fragment_favourites;

    public static FavouritesFragment getInstance(Context context) {
        Bundle args = new Bundle();
        FavouritesFragment fragment = new FavouritesFragment();
        fragment.setArguments(args);
        fragment.setContext(context);
        fragment.setTitle(context.getString(R.string.favourites));

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
