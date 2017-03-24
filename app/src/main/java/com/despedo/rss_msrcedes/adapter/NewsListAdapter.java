package com.despedo.rss_msrcedes.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.despedo.rss_msrcedes.R;
import com.despedo.rss_msrcedes.dto.NewsDTO;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsViewHolder> {

    private List<NewsDTO> data;
    private Context context;

    public NewsListAdapter(List<NewsDTO> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        String imageUrl = data.get(position).getCover();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(context));
        imageLoader.displayImage(imageUrl, holder.image);

        holder.name.setText(data.get(position).getName());
        holder.link.setText(getShortLink(data.get(position).getLink()));
        holder.created.setText(getNewsTime(data.get(position).getCreatedAt()));
    }


    private String getShortLink(String link){
        String shortLink = link;
        shortLink = shortLink.substring(11, shortLink.indexOf("/", 10));
        shortLink = shortLink.replaceFirst(shortLink.subSequence(0, 1).toString(), shortLink.subSequence(0, 1).toString().toUpperCase());
        return shortLink;
    }

    private String getNewsTime(String created){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        Date newsTime = new Date();
        try {
            newsTime = dateFormat.parse(created);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date currentTime = new Date();

        int result = currentTime.getHours() - newsTime.getHours();

        if(currentTime.getDate() == newsTime.getDate() && result < 8){
            return String.valueOf(result) + " hours ago";
        }
        else {
            DateFormat resultDateFormat = new SimpleDateFormat("dd.MM.yy  HH:mm");
            return String.valueOf(resultDateFormat.format(newsTime));
        }

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
        ImageView image;
        TextView name;
        TextView link;
        TextView created;

        public NewsViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            link = (TextView) itemView.findViewById(R.id.link);
            created = (TextView) itemView.findViewById(R.id.created);

        }
    }

}
