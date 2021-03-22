package com.TMDB.TMDBapp.models;

import java.util.List;

public class Actor extends SearchResult{

    private List<SearchResult> known_for;

    public Actor(String poster, String media, int id) {
        super(poster, media, id);
    }

    public List<SearchResult> getKnown_for() {
        return known_for;
    }

    public void setKnown_for(List<SearchResult> known_for) {
        this.known_for = known_for;
    }
}
