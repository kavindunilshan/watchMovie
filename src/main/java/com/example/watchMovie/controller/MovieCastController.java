package com.example.watchMovie.controller;

import com.example.watchMovie.entity.MovieCast;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.service.MovieCastService;
import com.example.watchMovie.supportingEntity.CastMovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieCastController {
    @Autowired
    private MovieCastService service;

    @PostMapping("/movieCasts")
    public ResponseEntity<MovieCast> createMovieCast(@RequestBody MovieCast movieCast) {
        System.out.println(movieCast);
        return ResponseEntity.ok(this.service.createMovieCast(movieCast));
    }

    @PostMapping("/movieCastsList")
    public ResponseEntity<List<MovieCast>> createMovieCasts(@RequestBody List<MovieCast> movieCasts) {
        return ResponseEntity.ok(service.createMovieCastList(movieCasts));
    }

    @GetMapping("/movieCasts")
    public ResponseEntity<List<MovieCast>> getMovieCasts() {
        return ResponseEntity.ok(service.getMovieCastList());
    }

    @GetMapping("/movieCasts/{tid}/{hid}")
    public ResponseEntity<MovieCast> getMovieCastById(@PathVariable String tid, @PathVariable int hid) {
        CastMovieId id = new CastMovieId(tid, hid);
        return ResponseEntity.ok(service.getMovieCastById(id));
    }

    @PutMapping("/movieCasts")
    public ResponseEntity<MovieCast> updateMovieCast(@RequestBody MovieCast movieCast) {
        return ResponseEntity.ok().body(service.updateMovieCast(movieCast));
    }

    @PatchMapping("/movieCasts")
    public ResponseEntity<MovieCast> updateMovieCastPart(@RequestBody MovieCast movieCast) throws IdNotFoundException {
        return ResponseEntity.ok().body(service.updateMovieCastById(movieCast));
    }

    @DeleteMapping("/movieCasts/{tid}/{hid}")
    public ResponseEntity<String> deleteMovieCast(@PathVariable String tid, @PathVariable int hid) {
        CastMovieId id = new CastMovieId(tid, hid);
        return ResponseEntity.ok(service.deleteById(id));
    }
}
