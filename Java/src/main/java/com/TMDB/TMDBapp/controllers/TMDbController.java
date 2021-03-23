package com.TMDB.TMDBapp.controllers;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import com.TMDB.TMDBapp.services.TMDbService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TMDbController {

    @Autowired
    private Environment env;


    public final String BASE_URL = "https://api.themoviedb.org/3";
    private final String API_KEY = env.getProperty("TMDB_APP_API_KEY"); // need to hide key

    TMDbService tmDbService = new TMDbService(BASE_URL, API_KEY);

    //MULTI SEARCH
    @RequestMapping(path="/search/multi/{query}", method = RequestMethod.GET)
    public ResponseEntity<String> multiSearch(@PathVariable String query){
        return tmDbService.multiSearch(query);
    }

    //MOVIE SEARCH
    @RequestMapping(path="/search/movie/{query}", method = RequestMethod.GET)
    public Movie[] movieSearch(@PathVariable String query){
        return tmDbService.movieSearch(query);
    }

    //TV SEARCH
    @RequestMapping(path="/search/tv/{query}", method = RequestMethod.GET)
    public TVShow[] tvSearch(@PathVariable String query){
        return tmDbService.tvSearch(query);
    }

    //ACTOR SEARCH
    @RequestMapping(path="/search/actor/{query}", method = RequestMethod.GET)
    public Actor[] actorSearch(@PathVariable String query){
        return tmDbService.actorSearch(query);
    }

}
