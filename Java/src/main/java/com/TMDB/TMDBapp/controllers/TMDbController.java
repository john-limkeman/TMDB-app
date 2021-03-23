package com.TMDB.TMDBapp.controllers;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import com.TMDB.TMDBapp.services.TMDbService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMDbController {

    public final String BASE_URL = "https://api.themoviedb.org/3";
    private final String API_KEY = "917369bb118862e487faedc2fa6bf48d"; // need to hide key

    TMDbService tmDbService = new TMDbService(BASE_URL, API_KEY);

    //MULTI SEARCH
    @RequestMapping(path="/search/multi", method = RequestMethod.GET)
    public SearchResult[] multiSearch(@RequestBody String query){
        return tmDbService.multiSearch(query);
    }

    //MOVIE SEARCH
    @RequestMapping(path="/search/movie", method = RequestMethod.GET)
    public Movie[] movieSearch(@RequestBody String query){
        return tmDbService.movieSearch(query);
    }

    //TV SEARCH
    @RequestMapping(path="/search/tv", method = RequestMethod.GET)
    public TVShow[] tvSearch(@RequestBody String query){
        return tmDbService.tvSearch(query);
    }

    //ACTOR SEARCH
    @RequestMapping(path="/search/actor", method = RequestMethod.GET)
    public Actor[] actorSearch(@RequestBody String query){
        return tmDbService.actorSearch(query);
    }

}
