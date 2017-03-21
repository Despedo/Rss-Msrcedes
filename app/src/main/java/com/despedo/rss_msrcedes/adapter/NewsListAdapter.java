package com.despedo.rss_msrcedes.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.despedo.rss_msrcedes.R;
import com.despedo.rss_msrcedes.dto.NewsDTO;

import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<NewsDTO> data;

    public NewsListAdapter(List<NewsDTO> data) {
        this.data = data;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        String shortLink = data.get(position).getLink();
        shortLink = shortLink.substring(11, shortLink.indexOf("/", 10));
        shortLink = shortLink.replaceFirst(shortLink.subSequence(0, 1).toString(), shortLink.subSequence(0, 1).toString().toUpperCase());
        holder.link.setText(shortLink);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<NewsDTO> data) {
        this.data = data;
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView name;
        TextView link;

        public NewsViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            name = (TextView) itemView.findViewById(R.id.name);
            link = (TextView) itemView.findViewById(R.id.link);
        }
    }

}
