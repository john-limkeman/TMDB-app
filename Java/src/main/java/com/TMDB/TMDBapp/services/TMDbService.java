package com.TMDB.TMDBapp.services;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
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
    public String multiSearch(String query){

      String response = rest.getForObject(BASE_URL + "/search/multi?api_key=" + API_KEY + REQUEST_PARAMETERS + query, String.class);
      System.out.println(response);
      return response;
    }

    //conduct movie search
    public String movieSearch(String query){
        String response = rest.getForObject(BASE_URL + "/search/movie?api_key=" + API_KEY + REQUEST_PARAMETERS + query, String.class);
        System.out.println(response);
        return response;    }

    //conduct tv show search
    public String tvSearch(String query){
        String response = rest.getForObject(BASE_URL + "/search/tv?api_key=" + API_KEY + REQUEST_PARAMETERS + query, String.class);
        System.out.println(response);
        return response;    }

    //conduct actor search
    public String actorSearch(String query){
        String response = rest.getForObject(BASE_URL + "/search/person?api_key=" + API_KEY + REQUEST_PARAMETERS + query, String.class);
        System.out.println(response);
        return response;   }
}
