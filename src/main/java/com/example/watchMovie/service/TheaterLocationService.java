package com.example.watchMovie.service;

import com.example.watchMovie.entity.TheaterLocation;
import com.example.watchMovie.exception.IdNotFoundException;
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

    public TheaterLocation getTheaterLocationById(String tid) {
        return theaterLocationRepository.findById(tid).orElse(null);
    }

    public TheaterLocation updateTheaterLocation(TheaterLocation theaterLocation) {
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

    public TheaterLocation updateTheaterLocationById(TheaterLocation location) {
        Optional<TheaterLocation> locationFound = theaterLocationRepository.findById(location.getTid());
        if (locationFound.isPresent()) {
            TheaterLocation locationUpdate = locationFound.get();

            if(0 < locationUpdate.getDistrict().length())
                locationUpdate.setDistrict(location.getDistrict());

            if(0 < locationUpdate.getCity().length())
                locationUpdate.setCity(location.getCity());

            if(0 < locationUpdate.getLat().length())
                locationUpdate.setLat(location.getLat());

            if(0 < locationUpdate.getLang().length())
                locationUpdate.setLang(location.getLang());

            return theaterLocationRepository.save(locationUpdate);
        } else {
            throw new IdNotFoundException("Invalid location Id");
        }
    }

    public String deleteById(String tid) {
        theaterLocationRepository.deleteById(tid);
        return "Theater Location " + tid + " is deleted.";
    }

}
