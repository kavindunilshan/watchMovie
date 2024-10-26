package com.example.watchMovie.service;

import com.example.watchMovie.entity.TheaterPicture;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.TheaterPictureRepository;
import com.example.watchMovie.supportingEntity.TheaterPictureId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterPictureService {
    @Autowired
    private TheaterPictureRepository theaterPictureRepository;

    public TheaterPicture createTheaterPicture(TheaterPicture theaterPicture) {
        return theaterPictureRepository.save(theaterPicture);
    }

    public List<TheaterPicture> createTheaterPictureList(List<TheaterPicture> list) {
        return theaterPictureRepository.saveAll(list);
    }

    public List<TheaterPicture> getTheaterPictureList() {
        return theaterPictureRepository.findAll();
    }

    public TheaterPicture getTheaterPictureById(TheaterPictureId id) {
        return theaterPictureRepository.findById(id).orElse(null);
    }

    public TheaterPicture updateTheaterPicture(TheaterPicture theaterPicture) {
        Optional<TheaterPicture> theaterPictureFound = theaterPictureRepository.findById(theaterPicture.getId());
        if (theaterPictureFound.isPresent()) {
            TheaterPicture theaterPictureUpdate = theaterPictureFound.get();
            theaterPictureUpdate.setName(theaterPicture.getName());

            return theaterPictureRepository.save(theaterPicture);
        } else {
            throw new IdNotFoundException("Invalid TheaterPicture Id");
        }
    }

    public TheaterPicture updateTheaterPictureById(TheaterPicture theaterPicture) {
        Optional<TheaterPicture> theaterPictureFound = theaterPictureRepository.findById(theaterPicture.getId());
        if (theaterPictureFound.isPresent()) {
            TheaterPicture theaterPictureUpdate = theaterPictureFound.get();

            if(0 < theaterPicture.getName().length())
                theaterPictureUpdate.setName(theaterPicture.getName());

            return theaterPictureRepository.save(theaterPictureUpdate);
        } else {
            throw new IdNotFoundException("Invalid TheaterPicture Id");
        }
    }


    public String deleteById(TheaterPictureId id) {
        theaterPictureRepository.deleteById(id);
        return "TheaterPicture " + id + " is deleted.";
    }

}
