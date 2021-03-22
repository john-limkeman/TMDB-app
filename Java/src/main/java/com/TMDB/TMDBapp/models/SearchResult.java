package com.TMDB.TMDBapp.models;

public abstract class SearchResult {
    private String poster_path;
    private String media_type;
    private int id;

    public SearchResult(String poster, String media, int id){
        this.poster_path = poster;
        this.media_type = media;
        this.id = id;
    }


    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
