package com.example.watchMovie.controller;

import com.example.watchMovie.entity.SeatData;
import com.example.watchMovie.service.SeatDataService;
import com.example.watchMovie.supportingEntity.HallId;
import com.example.watchMovie.supportingEntity.MovieId;
import com.example.watchMovie.supportingEntity.SeatDataId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SeatDataController {
    @Autowired
    private SeatDataService service;

    @PostMapping("/seatDatas")
    public ResponseEntity<SeatData> createSeatData(@RequestBody SeatData seatData) {
        System.out.println(seatData);
        return ResponseEntity.ok(this.service.createSeatData(seatData));
    }

    @PostMapping("/seatDatasList")
    public ResponseEntity<List<SeatData>> createSeatDatas(@RequestBody List<SeatData> seatDatas) {
        return ResponseEntity.ok(service.createSeatDataList(seatDatas));
    }

    @GetMapping("/seatDatas")
    public ResponseEntity<List<SeatData>> getSeatDatas() {
        return ResponseEntity.ok(service.getSeatDataList());
    }

    @GetMapping("/seatDatas/{tid}/{hid}/{mid}")
    public ResponseEntity<SeatData> getSeatDataById(@PathVariable int tid,
                                                            @PathVariable int mid, @PathVariable String timeSlot,
                                                            @PathVariable String date) 
    {
        SeatDataId id = new SeatDataId(tid, mid, timeSlot, date);
        return ResponseEntity.ok(service.getSeatDataById(id));
    }

    @PutMapping("/seatDatas")
    public ResponseEntity<SeatData> updateSeatData(@RequestBody SeatData seatData) {
        return ResponseEntity.ok().body(service.updateSeatData(seatData));
    }

    @PatchMapping("/seatDatas")
    public ResponseEntity<SeatData> updateSeatDataPart(@RequestBody SeatData seatData) {
        return ResponseEntity.ok().body(service.updateSeatDataById(seatData));
    }

    @DeleteMapping("/seatDatas/{tid}/{hid}/{mid}")
    public ResponseEntity<String> deleteSeatData
            (@PathVariable int tid,
             @PathVariable int mid, @PathVariable String timeSlot,
             @PathVariable String date)
    {
        SeatDataId id = new SeatDataId(tid, mid, timeSlot, date);
        return ResponseEntity.ok(service.deleteById(id));
    }

}
