package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Hall;
import com.example.watchMovie.service.HallService;
import com.example.watchMovie.supportingEntity.HallId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HallController {
    @Autowired
    private HallService service;

    @PostMapping("/addHall")
    public ResponseEntity<Hall> createHall(@RequestBody Hall hall) {
        System.out.println(hall);
        return ResponseEntity.ok(this.service.createHall(hall));
    }

    @PostMapping("/addHalls")
    public ResponseEntity<List<Hall>> createHalls(@RequestBody List<Hall> halls) {
        return ResponseEntity.ok(service.createHallList(halls));
    }

    @GetMapping("/halls")
    public ResponseEntity<List<Hall>> getHalls() {
        return ResponseEntity.ok(service.getHallList());
    }

    @GetMapping("/halls/{tid}/{hid}")
    public ResponseEntity<Hall> getHallById(@PathVariable int tid, @PathVariable int hid) {
        HallId id = new HallId(tid, hid);
        return ResponseEntity.ok(service.getHallById(id));
    }

    @PutMapping("/updateHall")
    public ResponseEntity<Hall> updateHall(@RequestBody Hall hall) {
        return ResponseEntity.ok().body(service.updateHallById(hall));
    }

    @DeleteMapping("/deleteHall/{tid}/{hid}")
    public ResponseEntity<String> deleteHall(@PathVariable int tid, @PathVariable int hid) {
        HallId id = new HallId(tid, hid);
        return ResponseEntity.ok(service.deleteById(id));
    }
}
