package com.example.watchMovie.service;

import com.example.watchMovie.entity.MovieCast;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.MovieCastRepository;
import com.example.watchMovie.supportingEntity.CastMovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCastService {
    @Autowired
    private MovieCastRepository movieCastRepository;

    public MovieCast createMovieCast(MovieCast movieCast) {
        return movieCastRepository.save(movieCast);
    }

    public List<MovieCast> createMovieCastList(List<MovieCast> list) {
        return movieCastRepository.saveAll(list);
    }

    public List<MovieCast> getMovieCastList() {
        return movieCastRepository.findAll();
    }

    public MovieCast getMovieCastById(CastMovieId id) {
        return movieCastRepository.findById(id).orElse(null);
    }

    public MovieCast updateMovieCast(MovieCast movieCast) {
        Optional<MovieCast> movieCastFound = movieCastRepository.findById(movieCast.getId());
        if (movieCastFound.isPresent()) {
            MovieCast movieCastUpdate = movieCastFound.get();

            return movieCastRepository.save(movieCast);
        } else {
            throw new IdNotFoundException("Invalid MovieCast Id");
        }
    }

    public MovieCast updateMovieCastById(MovieCast movieCast) {
        Optional<MovieCast> movieCastFound = movieCastRepository.findById(movieCast.getId());
        if (movieCastFound.isPresent()) {
            MovieCast movieCastUpdate = movieCastFound.get();
            return movieCastRepository.save(movieCastUpdate);

        } else {
            throw new IdNotFoundException("Invalid MovieCast Id");
        }
    }

    public String deleteById(CastMovieId id) {
        movieCastRepository.deleteById(id);
        return "MovieCast " + id + " is deleted.";
    }

}
