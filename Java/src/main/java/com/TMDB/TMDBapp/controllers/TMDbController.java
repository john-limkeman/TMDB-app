package com.TMDB.TMDBapp.controllers;

import com.TMDB.TMDBapp.models.Actor;
import com.TMDB.TMDBapp.models.Movie;
import com.TMDB.TMDBapp.models.SearchResult;
import com.TMDB.TMDBapp.models.TVShow;
import com.TMDB.TMDBapp.services.TMDbService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TMDbController {

    public final String BASE_URL = "https://api.themoviedb.org/3";
    private final String API_KEY = "917369bb118862e487faedc2fa6bf48d"; // need to hide key

    TMDbService tmDbService = new TMDbService(BASE_URL, API_KEY);

    //MULTI SEARCH
    @RequestMapping(path="/search/multi/{query}", method = RequestMethod.GET)
    public SearchResult[] multiSearch(@PathVariable String query){
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
