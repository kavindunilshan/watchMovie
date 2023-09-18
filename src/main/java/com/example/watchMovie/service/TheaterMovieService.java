package com.example.watchMovie.service;

import com.example.watchMovie.entity.TheaterMovie;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.TheaterMovieRepository;
import com.example.watchMovie.supportingEntity.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterMovieService {
    @Autowired
    private TheaterMovieRepository theaterMovieRepository;

    public TheaterMovie createTheaterMovie(TheaterMovie theaterMovie) {
        return theaterMovieRepository.save(theaterMovie);
    }

    public List<TheaterMovie> createTheaterMovieList(List<TheaterMovie> list) {
        return theaterMovieRepository.saveAll(list);
    }

    public List<TheaterMovie> getTheaterMovieList() {
        return theaterMovieRepository.findAll();
    }

    public TheaterMovie getTheaterMovieById(MovieId id) {
        return theaterMovieRepository.findById(id).orElse(null);
    }

    public TheaterMovie updateTheaterMovie(TheaterMovie theaterMovie) {
        Optional<TheaterMovie> theaterMovieFound = theaterMovieRepository.findById(theaterMovie.getId());
        if (theaterMovieFound.isPresent()) {
            TheaterMovie theaterMovieUpdate = theaterMovieFound.get();
            theaterMovieUpdate.setFullPrice(theaterMovie.getFullPrice());

            return theaterMovieRepository.save(theaterMovie);
        } else {
            return null;
        }
    }

    public TheaterMovie updateTheaterMovieById(TheaterMovie theaterMovie) {
        Optional<TheaterMovie> theaterMovieFound = theaterMovieRepository.findById(theaterMovie.getId());
        if (theaterMovieFound.isPresent()) {
            TheaterMovie theaterMovieUpdate = theaterMovieFound.get();

            if(0 < theaterMovie.getFullPrice())
                theaterMovieUpdate.setFullPrice(theaterMovie.getFullPrice());

            if(theaterMovie.getMovie() != null)
                theaterMovieUpdate.setMovie(theaterMovie.getMovie());

            return theaterMovieRepository.save(theaterMovieUpdate);
        } else {
            throw new IdNotFoundException("Invalid theater movie Id");
        }
    }

    public String deleteById(MovieId id) {
        theaterMovieRepository.deleteById(id);
        return "TheaterMovie " + id + " is deleted.";
    }

}
