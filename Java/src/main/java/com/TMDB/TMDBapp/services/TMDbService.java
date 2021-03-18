package com.TMDB.TMDBapp.services;

import org.springframework.web.client.RestTemplate;

public class TMDbService {

    private final String BASE_URL;
    public RestTemplate rest = new RestTemplate();

    TMDbService(String url){
        BASE_URL = url;
    }

    //conduct multi-search
    //conduct movie search
    //conduct tv show search
    //conduct actor search
}
