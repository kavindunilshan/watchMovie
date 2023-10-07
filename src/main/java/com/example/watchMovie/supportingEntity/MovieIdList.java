package com.example.watchMovie.supportingEntity;

import java.util.List;

public class MovieIdList {
    public MovieIdList(List<Integer> movies) {
        this.movies = movies;
    }

    private List<Integer> movies;

    public List<Integer> getMovies() {
        return movies;
    }

    public void setMovies(List<Integer> movies) {
        this.movies = movies;
    }
}
