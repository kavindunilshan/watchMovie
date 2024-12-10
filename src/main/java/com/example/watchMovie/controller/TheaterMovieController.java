package com.example.watchMovie.controller;

import com.example.watchMovie.entity.TheaterMovie;
import com.example.watchMovie.service.TheaterMovieService;
import com.example.watchMovie.supportingEntity.HallId;
import com.example.watchMovie.supportingEntity.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaterMovies")
public class TheaterMovieController {
    @Autowired
    private TheaterMovieService service;

    @PostMapping("")
    public ResponseEntity<TheaterMovie> createTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
        System.out.println(theaterMovie);
        return ResponseEntity.ok(this.service.createTheaterMovie(theaterMovie));
    }

    @PostMapping("/list")
    public ResponseEntity<List<TheaterMovie>> createTheaterMovies(@RequestBody List<TheaterMovie> theaterMovies) {
        return ResponseEntity.ok(service.createTheaterMovieList(theaterMovies));
    }

    @GetMapping("")
    public ResponseEntity<List<TheaterMovie>> getAllTheaterMovies() {
        return ResponseEntity.ok(service.getAllTheaterMovieList());
    }

    @GetMapping("/{tid}")
    public ResponseEntity<List<TheaterMovie>> getTheaterMovies(@PathVariable String tid) {
        return ResponseEntity.ok(service.getTheaterMovieList(tid));
    }

    @GetMapping("/{tid}/{mid}/{slot}")
    public ResponseEntity<TheaterMovie> getTheaterMovieById(@PathVariable String tid,
                                                            @PathVariable int mid,
                                                            @PathVariable String  slot) {
        MovieId id = new MovieId(tid, mid, slot);
        return ResponseEntity.ok(service.getTheaterMovieById(id));
    }

    @PutMapping("")
    public ResponseEntity<TheaterMovie> updateTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
        return ResponseEntity.ok().body(service.updateTheaterMovie(theaterMovie));
    }

    @PatchMapping("")
    public ResponseEntity<TheaterMovie> updateTheaterMoviePart(@RequestBody TheaterMovie theaterMovie) {
        return ResponseEntity.ok().body(service.updateTheaterMovieById(theaterMovie));
    }

    @DeleteMapping("/{tid}/{mid}/{slot}")
    public ResponseEntity<String> deleteTheaterMovie
            (@PathVariable String tid,
             @PathVariable int mid,
             @PathVariable String  slot) {
        MovieId id = new MovieId(tid, mid, slot);
        return ResponseEntity.ok(service.deleteById(id));
    }

}
