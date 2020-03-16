package com.kiki.movieinfoservice.model;

public class MovieSummary {

    private String id;

    private String title;
    private String overview;

    public MovieSummary(String id, String title, String overview) {
        this.id = id;
        this.title = title;
        this.overview = overview;
    }

    public MovieSummary() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
