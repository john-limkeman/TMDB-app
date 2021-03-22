package com.TMDB.TMDBapp.controllers;

import com.TMDB.TMDBapp.services.TMDbService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TMDbController {

    public final String BASE_URL = "";

    TMDbService tmDbService = new TMDbService(BASE_URL);

}
