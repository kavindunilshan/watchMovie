package com.example.watchMovie.service;

import com.example.watchMovie.entity.SeatData;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.SeatDataRepository;
import com.example.watchMovie.supportingEntity.SeatDataId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatDataService {
    @Autowired
    private SeatDataRepository seatDataRepository;

    public SeatData createSeatData(SeatData seatData) {
        return seatDataRepository.save(seatData);
    }

    public List<SeatData> createSeatDataList(List<SeatData> list) {
        return seatDataRepository.saveAll(list);
    }

    public List<SeatData> getSeatDataList() {
        return seatDataRepository.findAll();
    }

    public SeatData getSeatDataById(SeatDataId id) {
        return seatDataRepository.findById(id).orElse(null);
    }

    public SeatData updateSeatData(SeatData seatData) {
        System.out.println("Seat data: " + seatData);
        return seatDataRepository.save(seatData);
    }

    public SeatData updateSeatDataById(SeatData seatData) {
        Optional<SeatData> seatDataFound = seatDataRepository.findById(seatData.getId());
        if (seatDataFound.isPresent()) {
            SeatData seatDataUpdate = seatDataFound.get();

            if(0 < seatData.getNumSeats())
                seatDataUpdate.setNumSeats(seatData.getNumSeats());

            if(0 < seatData.getHid())
                seatDataUpdate.setHid(seatData.getHid());

            if(0 < seatData.getSeats().length())
                seatDataUpdate.setSeats(seatData.getSeats());

            return seatDataRepository.save(seatDataUpdate);
        } else {
            throw new IdNotFoundException("Invalid Seat Data Id");
        }
    }

    public String deleteById(SeatDataId id) {
        seatDataRepository.deleteById(id);
        return "Seat Data " + id + " is deleted.";
    }

}
