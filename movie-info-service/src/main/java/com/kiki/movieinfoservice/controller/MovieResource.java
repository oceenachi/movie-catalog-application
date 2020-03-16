package com.kiki.movieinfoservice.controller;


import com.kiki.movieinfoservice.model.Movie;
import com.kiki.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        MovieSummary movieSummary = restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey,
                MovieSummary.class
        );
//        MovieSummary movieSummary = restTemplate.getForObject("http://api.themoviedb.org/3/movie/90?api_key=87de152e8e673005d079b93f6e06cdf9", MovieSummary.class );
//        http://api.themoviedb.org/3/movie/90?api_key=87de152e8e673005d079b93f6e06cdf9

        assert movieSummary != null;
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
