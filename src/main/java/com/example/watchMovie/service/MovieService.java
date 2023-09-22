package com.example.watchMovie.service;

import com.example.watchMovie.entity.Movie;
import com.example.watchMovie.exception.IdNotFoundException;
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

    public List<Movie> getMovieByIds(List<Integer> id) {
        return movieRepository.findAllById(id);
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
            throw new IdNotFoundException("Invalid movie Id");
        }
    }

    public Movie updateMovieById(Movie movie) {
        Optional<Movie> movieFound = movieRepository.findById(movie.getMid());
        if (movieFound.isPresent()) {
            Movie movieUpdate = movieFound.get();

            if(0 < movie.getName().length())
                movieUpdate.setName(movie.getName());

            if(0 < movie.getActor().length())
                movieUpdate.setActor(movie.getActor());

            if(0 < movie.getActress().length())
                movieUpdate.setActress(movie.getActress());

            if(0 < movie.getDuration().length())
                movieUpdate.setDuration(movie.getDuration());

            if(0 < movie.getDirector().length())
                movieUpdate.setDirector(movie.getDirector());

            if(0 < movie.getPictures().size())
                movieUpdate.setPictures(movie.getPictures());

            return movieRepository.save(movieUpdate);
        } else {
            throw new IdNotFoundException("Invalid movie Id");
        }
    }

    public String deleteById(int id) {
        movieRepository.deleteById(id);
        return "Movie " + id + " is deleted.";
    }

}
