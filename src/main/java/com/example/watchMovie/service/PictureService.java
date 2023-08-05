package com.example.watchMovie.service;

import com.example.watchMovie.entity.Picture;
import com.example.watchMovie.repository.PictureRepository;
import com.example.watchMovie.supportingEntity.PictureId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService {
    @Autowired
    private PictureRepository pictureRepository;

    public Picture createPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    public List<Picture> createPictureList(List<Picture> list) {
        return pictureRepository.saveAll(list);
    }

    public List<Picture> getPictureList() {
        return pictureRepository.findAll();
    }

    public Picture getPictureById(PictureId id) {
        return pictureRepository.findById(id).orElse(null);
    }

    public Picture updatePicture(Picture picture) {
        Optional<Picture> pictureFound = pictureRepository.findById(picture.getId());
        if (pictureFound.isPresent()) {
            Picture pictureUpdate = pictureFound.get();
            pictureUpdate.setName(picture.getName());

            return pictureRepository.save(picture);
        } else {
            return null;
        }
    }

    public Picture updatePictureById(Picture picture) {
        Optional<Picture> pictureFound = pictureRepository.findById(picture.getId());
        if (pictureFound.isPresent()) {
            Picture pictureUpdate = pictureFound.get();

            if(0 < picture.getName().length())
                pictureUpdate.setName(picture.getName());

            return pictureRepository.save(pictureUpdate);
        } else {
            return null;
        }
    }


    public String deleteById(PictureId id) {
        pictureRepository.deleteById(id);
        return "Picture " + id + " is deleted.";
    }

}
