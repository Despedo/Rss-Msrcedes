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

    public NewsDTO() {
    }

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

    public void setId(String id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
