package com.example.watchMovie.controller;

import com.example.watchMovie.entity.TheaterMovie;
import com.example.watchMovie.service.TheaterMovieService;
import com.example.watchMovie.supportingEntity.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterMovieController {
    @Autowired
    private TheaterMovieService service;

    @PostMapping("/addTheaterMovie")
    public ResponseEntity<TheaterMovie> createTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
        System.out.println(theaterMovie);
        return ResponseEntity.ok(this.service.createTheaterMovie(theaterMovie));
    }

    @PostMapping("/addTheaterMovies")
    public ResponseEntity<List<TheaterMovie>> createTheaterMovies(@RequestBody List<TheaterMovie> theaterMovies) {
        return ResponseEntity.ok(service.createTheaterMovieList(theaterMovies));
    }

    @GetMapping("/theaterMovies")
    public ResponseEntity<List<TheaterMovie>> getTheaterMovies() {
        return ResponseEntity.ok(service.getTheaterMovieList());
    }

    @GetMapping("/theaterMovies/{id}")
    public ResponseEntity<TheaterMovie> getTheaterMovieById(@PathVariable MovieId id) {
        return ResponseEntity.ok(service.getTheaterMovieById(id));
    }

    @PutMapping("/updateTheaterMovie")
    public ResponseEntity<TheaterMovie> updateTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
        return ResponseEntity.ok().body(service.updateTheaterMovieById(theaterMovie));
    }

    @DeleteMapping("/deleteTheaterMovie/{id}")
    public ResponseEntity<String> deleteTheaterMovie(@PathVariable MovieId id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
