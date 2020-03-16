package com.kiki.ratingsdataservice.controller;


import com.kiki.ratingsdataservice.models.Rating;
import com.kiki.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rating")
public class RatingResource {


    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 5 );
    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){

        UserRating userRating = new UserRating();
        userRating.initData(userId);
        return userRating;
    }
}
