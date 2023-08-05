package com.example.watchMovie.controller;

import com.example.watchMovie.entity.TheaterLocation;
import com.example.watchMovie.service.TheaterLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterLocationController {
    @Autowired
    private TheaterLocationService service;

    @PostMapping("/locations")
    public ResponseEntity<TheaterLocation> createTheaterLocation(@RequestBody TheaterLocation theaterLocation) {
        System.out.println(theaterLocation);
        return ResponseEntity.ok(this.service.createTheaterLocation(theaterLocation));
    }

    @PostMapping("/locations")
    public ResponseEntity<List<TheaterLocation>> createTheaterLocations(@RequestBody List<TheaterLocation> theaterLocations) {
        return ResponseEntity.ok(service.createTheaterLocationList(theaterLocations));
    }

    @GetMapping("/locations")
    public ResponseEntity<List<TheaterLocation>> getTheaterLocations() {
        return ResponseEntity.ok(service.getTheaterLocationList());
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<TheaterLocation> getTheaterLocationById(@PathVariable int id) {
        return ResponseEntity.ok(service.getTheaterLocationById(id));
    }

    @PutMapping("/locations")
    public ResponseEntity<TheaterLocation> updateTheaterLocation(@RequestBody TheaterLocation theaterLocation) {
        return ResponseEntity.ok().body(service.updateTheaterLocation(theaterLocation));
    }

    @PatchMapping("/updateTheaterLocation")
    public ResponseEntity<TheaterLocation> updateTheaterLocationPart(@RequestBody TheaterLocation theaterLocation) {
        return ResponseEntity.ok().body(service.updateTheaterLocationById(theaterLocation));
    }

    @DeleteMapping("/locations/{id}")
    public ResponseEntity<String> deleteTheaterLocation(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
