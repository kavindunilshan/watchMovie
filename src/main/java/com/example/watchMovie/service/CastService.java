package com.example.watchMovie.service;

import com.example.watchMovie.entity.Cast;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CastService {
    @Autowired
    private CastRepository castRepository;

    public Cast createCast(Cast cast) {
        return castRepository.save(cast);
    }

    public List<Cast> createCastList(List<Cast> list) {
        return castRepository.saveAll(list);
    }

    public List<Cast> getCastList() {
        return castRepository.findAll();
    }

    public Cast getCastById(int id) {
        return castRepository.findById(id).orElse(null);
    }

    public Cast updateCast(Cast cast) {
        Optional<Cast> castFound = castRepository.findById(cast.getId());
        if (castFound.isPresent()) {
            Cast castUpdate = castFound.get();
            castUpdate.setName(cast.getName());
            castUpdate.setWiki(cast.getWiki());

            return castRepository.save(cast);
        } else {
            throw new IdNotFoundException("Invalid Cast Id");
        }
    }

    public Cast updateCastById(Cast cast) {
        Optional<Cast> castFound = castRepository.findById(cast.getId());
        if (castFound.isPresent()) {
            Cast castUpdate = castFound.get();

            if(0 < cast.getName().length())
                castUpdate.setName(cast.getName());

            if(0 < cast.getWiki().length())
                castUpdate.setWiki(cast.getWiki());

            return castRepository.save(castUpdate);
        } else {
            throw new IdNotFoundException("Invalid Cast Id");
        }
    }

    public String deleteById(int id) {
        castRepository.deleteById(id);
        return "Cast " + id + " is deleted.";
    }

}
