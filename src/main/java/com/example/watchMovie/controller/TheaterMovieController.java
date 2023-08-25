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
@RequestMapping("/api")
public class TheaterMovieController {
    @Autowired
    private TheaterMovieService service;

    @PostMapping("/theaterMovies")
    public ResponseEntity<TheaterMovie> createTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
        System.out.println(theaterMovie);
        return ResponseEntity.ok(this.service.createTheaterMovie(theaterMovie));
    }

    @PostMapping("/theaterMoviesList")
    public ResponseEntity<List<TheaterMovie>> createTheaterMovies(@RequestBody List<TheaterMovie> theaterMovies) {
        return ResponseEntity.ok(service.createTheaterMovieList(theaterMovies));
    }

    @GetMapping("/theaterMovies")
    public ResponseEntity<List<TheaterMovie>> getTheaterMovies() {
        return ResponseEntity.ok(service.getTheaterMovieList());
    }

    @GetMapping("/theaterMovies/{tid}/{hid}/{mid}")
    public ResponseEntity<TheaterMovie> getTheaterMovieById(@PathVariable int tid, @PathVariable int hid,
                                                            @PathVariable int mid) {
        MovieId id = new MovieId(new HallId(tid, hid), mid);
        return ResponseEntity.ok(service.getTheaterMovieById(id));
    }

    @PutMapping("/theaterMovies")
    public ResponseEntity<TheaterMovie> updateTheaterMovie(@RequestBody TheaterMovie theaterMovie) {
        return ResponseEntity.ok().body(service.updateTheaterMovie(theaterMovie));
    }

    @PatchMapping("/theaterMovies")
    public ResponseEntity<TheaterMovie> updateTheaterMoviePart(@RequestBody TheaterMovie theaterMovie) {
        return ResponseEntity.ok().body(service.updateTheaterMovieById(theaterMovie));
    }

    @DeleteMapping("/theaterMovies/{tid}/{hid}/{mid}")
    public ResponseEntity<String> deleteTheaterMovie
            (@PathVariable int tid, @PathVariable int hid,
             @PathVariable int mid) {
        MovieId id = new MovieId(new HallId(tid, hid), mid);
        return ResponseEntity.ok(service.deleteById(id));
    }

}
