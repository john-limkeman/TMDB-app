package com.TMDB.TMDBapp.services;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import org.springframework.web.client.RestTemplate;


public class TMDbService {

    //API KEY is passed in as part of the BASE_URL

    private final String BASE_URL;
    public RestTemplate rest = new RestTemplate();

    public TMDbService(String url){
        BASE_URL = url;
    }

    //conduct multi-search
    public SearchResult[] multiSearch(String query){
        return rest.getForObject(BASE_URL + "/search/multi?query=" + query, SearchResult[].class);
    }

    //conduct movie search
    public Movie[] movieSearch(String query){
        return rest.getForObject(BASE_URL + "/search/movie?query=" + query, Movie[].class);
    }

    //conduct tv show search
    public TVShow[] tvSearch(String query){
        return rest.getForObject(BASE_URL + "/search/tv?query=" + query, TVShow[].class);
    }

    //conduct actor search
    public Actor[] actorSearch(String query){
        return rest.getForObject(BASE_URL + "/search/actor?query=" + query, Actor[].class);
    }
}
