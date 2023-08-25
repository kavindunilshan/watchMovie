package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Movie;
import com.example.watchMovie.service.MovieService;
import com.example.watchMovie.supportingEntity.HallId;
import com.example.watchMovie.supportingEntity.MovieId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieService service;

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        System.out.println(movie);
        return ResponseEntity.ok(this.service.createMovie(movie));
    }

    @PostMapping("/moviesList")
    public ResponseEntity<List<Movie>> createMovies(@RequestBody List<Movie> movies) {
        return ResponseEntity.ok(service.createMovieList(movies));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(service.getMovieList());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id) {
        return ResponseEntity.ok(service.getMovieById(id));
    }

    @PutMapping("/movies")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(service.updateMovie(movie));
    }

    @PatchMapping("/movies")
    public ResponseEntity<Movie> updateMoviePart(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(service.updateMovieById(movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
