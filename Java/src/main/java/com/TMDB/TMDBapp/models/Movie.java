package com.TMDB.TMDBapp.models;

public class Movie extends SearchResult{
    private String overview;
    private String release_date;
    private String title;
    private int[] genre_ids;
    private String original_language;
    private int vote_count;
    private double vote_average;

    public Movie(String poster, String media, int id) {
        super(poster, media, id);
    }

    //GETTERS AND SETTERS
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int[] getGenre_ids() {
        return genre_ids;
    }
    public void setGenre_ids(int[] genre_ids) {
        this.genre_ids = genre_ids;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public int getVote_count() {
        return vote_count;
    }
    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
    public double getVote_average() {
        return vote_average;
    }
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }


}
