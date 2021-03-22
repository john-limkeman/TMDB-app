package com.TMDB.TMDBapp.services;

import com.TMDB.TMDBapp.models.SearchResult;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TMDbService {

    private final String BASE_URL;
    public RestTemplate rest = new RestTemplate();

    TMDbService(String url){
        BASE_URL = url;
    }

    //conduct multi-search
    private List<SearchResult> multiSearch(){
        return null;
    }

    //conduct movie search
    //conduct tv show search
    //conduct actor search
}
