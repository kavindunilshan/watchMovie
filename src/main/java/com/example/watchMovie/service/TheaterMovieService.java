package com.example.watchMovie.service;

import com.example.watchMovie.entity.TheaterMovie;
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
            theaterMovieUpdate.setDimension(theaterMovie.getDimension());
            theaterMovieUpdate.setTimeSlot(theaterMovie.getTimeSlot());
            theaterMovieUpdate.setPrice(theaterMovie.getPrice());

            return theaterMovieRepository.save(theaterMovie);
        } else {
            return null;
        }
    }

    public TheaterMovie updateTheaterMovieById(TheaterMovie theaterMovie) {
        Optional<TheaterMovie> theaterMovieFound = theaterMovieRepository.findById(theaterMovie.getId());
        if (theaterMovieFound.isPresent()) {
            TheaterMovie theaterMovieUpdate = theaterMovieFound.get();

            if(0 < theaterMovie.getDimension().length())
                theaterMovieUpdate.setDimension(theaterMovie.getDimension());

            if(0 < theaterMovie.getTimeSlot().length())
                theaterMovieUpdate.setTimeSlot(theaterMovie.getTimeSlot());

            if(0 < theaterMovie.getPrice())
                theaterMovieUpdate.setPrice(theaterMovie.getPrice());

            if(theaterMovie.getMovie() != null)
                theaterMovieUpdate.setMovie(theaterMovie.getMovie());

            return theaterMovieRepository.save(theaterMovieUpdate);
        } else {
            return null;
        }
    }

    public String deleteById(MovieId id) {
        theaterMovieRepository.deleteById(id);
        return "TheaterMovie " + id + " is deleted.";
    }

}
