package com.TMDB.TMDBapp.services;

import org.springframework.web.client.RestTemplate;


public class TMDbService {


    private final String BASE_URL;
    private String API_KEY;
    private String REQUEST_PARAMETERS = "&language=en-US&include_adult=false&query=";
    public RestTemplate rest = new RestTemplate();

    public TMDbService(String url, String api){
        BASE_URL = url;
        API_KEY = api;
    }

    //conduct multi-search
    public String multiSearch(String text, String page){
      String response = rest.getForObject(BASE_URL + "/search/multi?api_key=" + API_KEY + REQUEST_PARAMETERS + text +"&page=" + page , String.class);
      System.out.println(response);
      return response;
    }

    //conduct movie search
    public String movieSearch(String text, String page){
        String response = rest.getForObject(BASE_URL + "/search/movie?api_key=" + API_KEY + REQUEST_PARAMETERS + text + "&page=" + page, String.class);
        System.out.println("FETCHED TMBd API DATA: " + response);
        return response;
    }

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
