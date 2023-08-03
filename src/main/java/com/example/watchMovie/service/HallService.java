package com.example.watchMovie.service;

import com.example.watchMovie.entity.Hall;
import com.example.watchMovie.repository.HallRepository;
import com.example.watchMovie.supportingEntity.HallId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService {
    @Autowired
    private HallRepository hallRepository;

    public Hall createHall(Hall hall) {
        return hallRepository.save(hall);
    }

    public List<Hall> createHallList(List<Hall> list) {
        return hallRepository.saveAll(list);
    }

    public List<Hall> getHallList() {
        return hallRepository.findAll();
    }

    public Hall getHallById(HallId id) {
        return hallRepository.findById(id).orElse(null);
    }

    public Hall updateHallById(Hall hall) {
        Optional<Hall> hallFound = hallRepository.findById(hall.getId());
        if (hallFound.isPresent()) {
            Hall hallUpdate = hallFound.get();
            hallUpdate.setId(hall.getId());
            hallUpdate.setSeats(hall.getSeats());

            return hallRepository.save(hall);
        } else {
            return null;
        }
    }

    public String deleteById(HallId id) {
        hallRepository.deleteById(id);
        return "Hall " + id + " is deleted.";
    }

}