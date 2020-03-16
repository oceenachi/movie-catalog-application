package com.kiki.moviecatalogservice.controller;

import com.kiki.moviecatalogservice.model.CatalogItem;
import com.kiki.moviecatalogservice.model.Movie;
import com.kiki.moviecatalogservice.model.Rating;
import com.kiki.moviecatalogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate RestTemplate;

    private Rating rating;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    @HystrixCommand(fallbackMethod = "getFallbackCatalog")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        return ratings.getRatings().stream().map(rating -> {
//            Movie movie = RestTemplate.getForObject(url + rating.getMovieId(), Movie.class);
//            assert movie != null;


            Movie movie = RestTemplate.getForObject(url + rating.getMovieId(), Movie.class);
//            Movie movie = webClientBuilder.build()
//                    .get()
//                    .uri(url + rating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();
            assert movie != null;
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
        }).collect(Collectors.toList());

    }
    String movieUrl = "http://ratings-data-service/rating/users/";
    String url = "http://movie-info-service/movies/";

    private CatalogItem getCatalogItem(Rating rating){
        Movie movie = RestTemplate.getForObject(url + rating.getMovieId(), Movie.class);
        assert movie != null;
        return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating())
    }

    private UserRating getUserRating(@PathVariable("userId") String userId) {
        return RestTemplate.getForObject(movieUrl + userId, UserRating.class);
    }

    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId){
        return Arrays.asList(new CatalogItem("No movie", "", 0));
    }



    }
