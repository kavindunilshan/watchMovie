package com.example.watchMovie.service;

import com.example.watchMovie.entity.TheaterLocation;
import com.example.watchMovie.repository.TheaterLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterLocationService {
    @Autowired
    private TheaterLocationRepository theaterLocationRepository;

    public TheaterLocation createTheaterLocation(TheaterLocation theaterLocation) {
        return theaterLocationRepository.save(theaterLocation);
    }

    public List<TheaterLocation> createTheaterLocationList(List<TheaterLocation> list) {
        return theaterLocationRepository.saveAll(list);
    }

    public List<TheaterLocation> getTheaterLocationList() {
        return theaterLocationRepository.findAll();
    }

    public TheaterLocation getTheaterLocationById(int tid) {
        return theaterLocationRepository.findById(tid).orElse(null);
    }

    public TheaterLocation updateTheaterLocationById(TheaterLocation theaterLocation) {
        Optional<TheaterLocation> theaterLocationFound = theaterLocationRepository.findById(theaterLocation.getTid());
        if (theaterLocationFound.isPresent()) {
            TheaterLocation theaterLocationUpdate = theaterLocationFound.get();
            theaterLocationUpdate.setDistrict(theaterLocation.getDistrict());
            theaterLocationUpdate.setCity(theaterLocation.getCity());
            theaterLocationUpdate.setLat(theaterLocation.getLat());
            theaterLocationUpdate.setLang(theaterLocation.getLang());

            return theaterLocationRepository.save(theaterLocation);
        } else {
            return null;
        }
    }

    public String deleteById(int tid) {
        theaterLocationRepository.deleteById(tid);
        return "Theater Location " + tid + " is deleted.";
    }

}
