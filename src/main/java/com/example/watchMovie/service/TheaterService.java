package com.example.watchMovie.service;

import com.example.watchMovie.entity.Theater;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public Theater createTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    public List<Theater> createTheaterList(List<Theater> list) {
        return theaterRepository.saveAll(list);
    }

    public List<Theater> getTheaterList() {
        return theaterRepository.findAll();
    }

    public Theater getTheaterById(int tid) {
        return theaterRepository.findById(tid).orElse(null);
    }

    public Theater updateTheater(Theater theater) {
        Optional<Theater> theaterFound = theaterRepository.findById(theater.getTid());
        if (theaterFound.isPresent()) {
            Theater theaterUpdate = theaterFound.get();
            theaterUpdate.setName(theater.getName());
            theaterUpdate.setContactNumber(theater.getContactNumber());

            return theaterRepository.save(theater);
        } else {
            return null;
        }
    }

    public Theater updateTheaterById(Theater theater) {
        Optional<Theater> theaterFound = theaterRepository.findById(theater.getTid());
        if (theaterFound.isPresent()) {
            Theater theaterUpdate = theaterFound.get();

            if(0 < theater.getName().length())
                theaterUpdate.setName(theater.getName());

            if(0 < theater.getContactNumber())
                theaterUpdate.setContactNumber(theater.getContactNumber());

            if(theater.getLocation() != null)
                theaterUpdate.setLocation(theater.getLocation());

            if(0 < theater.getHalls().size())
                theaterUpdate.setHalls(theater.getHalls());

            return theaterRepository.save(theater);
        } else {
            throw new IdNotFoundException("Invalid theater Id");
        }
    }

    public String deleteById(int tid) {
        theaterRepository.deleteById(tid);
        return "Theater " + tid + " is deleted.";
    }

}
