package com.example.watchMovie.controller;

import com.example.watchMovie.entity.SeatData;
import com.example.watchMovie.service.SeatDataService;
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

    @PostMapping("/seatData")
    public synchronized ResponseEntity<SeatData> createSeatData(@RequestBody SeatData seatData) {
        return ResponseEntity.ok(this.service.createSeatData(seatData));
    }

    @PostMapping("/seatDataList")
    public synchronized ResponseEntity<List<SeatData>> createSeatDatas(@RequestBody List<SeatData> seatDatas) {
        return ResponseEntity.ok(service.createSeatDataList(seatDatas));
    }

    @GetMapping("/seatData")
    public ResponseEntity<List<SeatData>> getSeatDatas() {
        return ResponseEntity.ok(service.getSeatDataList());
    }

    @GetMapping("/seatData/{tid}/{mid}/{timeSlot}/{date}")
    public ResponseEntity<SeatData> getSeatDataById(@PathVariable String tid,
                                                            @PathVariable int mid,
                                                    @PathVariable String timeSlot,
                                                            @PathVariable String date) 
    {
        SeatDataId id = new SeatDataId(tid, mid, timeSlot, date);
        return ResponseEntity.ok(service.getSeatDataById(id));
    }

    @PutMapping("/seatData")
    public ResponseEntity<SeatData> updateSeatData(@RequestBody SeatData seatData) {
        return ResponseEntity.ok().body(service.updateSeatData(seatData));
    }

    @PatchMapping("/seatData")
    public ResponseEntity<SeatData> updateSeatDataPart(@RequestBody SeatData seatData) {
        return ResponseEntity.ok().body(service.updateSeatDataById(seatData));
    }

    @DeleteMapping("/seatData/{tid}/{mid}/{timeSlot}/{date}")
    public ResponseEntity<String> deleteSeatData
            (@PathVariable String tid,
             @PathVariable int mid, @PathVariable String timeSlot,
             @PathVariable String date)
    {
        SeatDataId id = new SeatDataId(tid, mid, timeSlot, date);
        return ResponseEntity.ok(service.deleteById(id));
    }

}
