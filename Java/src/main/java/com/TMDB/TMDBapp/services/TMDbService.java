package com.TMDB.TMDBapp.services;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class TMDbService {

    //API KEY is passed in as part of the BASE_URL

    private final String BASE_URL;
    private String API_KEY;
    private String REQUEST_PARAMETERS = "&language=en-US&include_adult=false&query=";
    public RestTemplate rest = new RestTemplate();

    public TMDbService(String url, String api){
        BASE_URL = url;
        API_KEY = api;
    }

    //conduct multi-search
    public ResponseEntity<String> multiSearch(String query){

        ResponseEntity<String> result = rest.getForEntity(BASE_URL + "/search/multi?api_key=" + API_KEY + REQUEST_PARAMETERS + query, String.class);
        System.out.println(result.getBody());
         return result;
    }

    //conduct movie search
    public Movie[] movieSearch(String query){
        return rest.getForObject(BASE_URL + "/search/movie?api_key=" + API_KEY + REQUEST_PARAMETERS + query, Movie[].class);
    }

    //conduct tv show search
    public TVShow[] tvSearch(String query){
        return rest.getForObject(BASE_URL + "/search/tv?api_key=" + API_KEY + REQUEST_PARAMETERS + query, TVShow[].class);
    }

    //conduct actor search
    public Actor[] actorSearch(String query){
        return rest.getForObject(BASE_URL + "/search/actor?api_key=" + API_KEY + REQUEST_PARAMETERS + query, Actor[].class);
    }
}
