package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Theater;
import com.example.watchMovie.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterController {
    @Autowired
    private TheaterService service;

    @PostMapping("/theaters")
    public ResponseEntity<Theater> createTheater(@RequestBody Theater theater) {
        System.out.println(theater);
        return ResponseEntity.ok(this.service.createTheater(theater));
    }

    @PostMapping("/theatersList")
    public ResponseEntity<List<Theater>> createTheaters(@RequestBody List<Theater> theaters) {
        return ResponseEntity.ok(service.createTheaterList(theaters));
    }

    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getTheaters() {
        return ResponseEntity.ok(service.getTheaterList());
    }

    @GetMapping("/theaters/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable String id) {
        return ResponseEntity.ok(service.getTheaterById(id));
    }

    @PutMapping("/theaters")
    public ResponseEntity<Theater> updateTheater(@RequestBody Theater theater) {
        return ResponseEntity.ok().body(service.updateTheater(theater));
    }

    @PatchMapping("/theaters")
    public ResponseEntity<Theater> updateTheaterpart(@RequestBody Theater theater) {
        return ResponseEntity.ok().body(service.updateTheaterById(theater));
    }

    @DeleteMapping("/theaters/{id}")
    public ResponseEntity<String> deleteTheater(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
