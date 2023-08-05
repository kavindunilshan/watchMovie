package com.example.watchMovie.service;

import com.example.watchMovie.entity.Movie;
import com.example.watchMovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> createMovieList(List<Movie> list) {
        return movieRepository.saveAll(list);
    }

    public List<Movie> getMovieList() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).orElse(null);
    }

    public Movie updateMovie(Movie movie) {
        Optional<Movie> movieFound = movieRepository.findById(movie.getMid());
        if (movieFound.isPresent()) {
            Movie movieUpdate = movieFound.get();
            movieUpdate.setName(movie.getName());
            movieUpdate.setActor(movie.getActor());
            movieUpdate.setActress(movie.getActress());
            movieUpdate.setDuration(movie.getDuration());
            movieUpdate.setDirector(movie.getDirector());
            movieUpdate.setPictures(movie.getPictures());

            return movieRepository.save(movie);
        } else {
            return null;
        }
    }

    public String deleteById(int id) {
        movieRepository.deleteById(id);
        return "Movie " + id + " is deleted.";
    }

}
