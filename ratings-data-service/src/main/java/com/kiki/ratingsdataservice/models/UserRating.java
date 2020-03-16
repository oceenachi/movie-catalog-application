package com.kiki.ratingsdataservice.models;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

public class UserRating {

    private String userId;
    private List<Rating> ratings;

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserRating() {
    }

    public void initData(String userId){
        this.setUserId(userId);
        this.setRatings(
                Arrays.asList(
                new Rating("94", 5),
                new Rating("590", 4),
                new Rating("90", 3)
        ));
    }
}
