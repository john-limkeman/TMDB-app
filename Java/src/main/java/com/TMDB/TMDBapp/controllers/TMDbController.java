package com.TMDB.TMDBapp.controllers;

import com.TMDB.TMDBapp.models.*;
import com.TMDB.TMDBapp.services.TMDbService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RestController
@CrossOrigin(origins = "*")
public class TMDbController {



    public final String BASE_URL = "https://api.themoviedb.org/3";
    private final String API_KEY = "917369bb118862e487faedc2fa6bf48d"; // need to hide key

    TMDbService tmDbService = new TMDbService(BASE_URL, API_KEY);


    //MULTI SEARCH

    @RequestMapping(path="/search/multi/{query}/{page}", method = RequestMethod.GET)
    public String multiSearch(@PathVariable String query, @PathVariable String page){
        return tmDbService.multiSearch(query, page);
    }

    //MOVIE SEARCH

    @RequestMapping(path="/search/movie/{text}/{page}", method = RequestMethod.GET)
    public String movieSearch(@PathVariable String text, @PathVariable String page){
        return tmDbService.movieSearch(text, page);
    }

//    //TV SEARCH
//    @CrossOrigin
//    @RequestMapping(path="/search/tv/{query}", method = RequestMethod.GET)
//    public String tvSearch(@PathVariable String query){
//
//        return tmDbService.tvSearch(query);
//    }
//
//    //ACTOR SEARCH
//    @CrossOrigin
//    @RequestMapping(path="/search/actor/{query}", method = RequestMethod.GET)
//    public String actorSearch(@PathVariable String query){
//
//        return tmDbService.actorSearch(query);
//    }

}
