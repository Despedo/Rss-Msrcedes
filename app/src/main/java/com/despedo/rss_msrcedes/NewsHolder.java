package com.despedo.rss_msrcedes;

import com.despedo.rss_msrcedes.dto.NewsDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Despedo on 23.03.2017.
 */

public class NewsHolder {
    private static List<NewsDTO> data;

    private static final NewsHolder ourInstance = new NewsHolder();

    public static NewsHolder getInstance() {
        return ourInstance;
    }

    private NewsHolder() {
        data = new ArrayList<>();
    }

    public static List<NewsDTO> getData() {
        return data;
    }

    public static void setData(List<NewsDTO> data) {
        NewsHolder.data = data;
    }

    public static void addData(NewsDTO dto){
        data.add(dto);
    }
}
