package com.despedo.rss_msrcedes.dto;

/**
 * Created by Despedo on 19.03.2017.
 */

public class NewsDTO {
    String id;
    String link;
    String name;
    String description;
    String cover;
    String top;
    String createdAt;

    public NewsDTO(String id, String link, String name, String description, String cover, String top, String createdAt) {
        this.id = id;
        this.link = link;
        this.name = name;
        this.description = description;
        this.cover = cover;
        this.top = top;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCover() {
        return cover;
    }

    public String getTop() {
        return top;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
