package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Cast;
import com.example.watchMovie.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CastController {
    @Autowired
    private CastService service;

    @PostMapping("/cast")
    public ResponseEntity<Cast> createCast(@RequestBody Cast cast) {
        System.out.println(cast);
        return ResponseEntity.ok(this.service.createCast(cast));
    }

    @PostMapping("/castsList")
    public ResponseEntity<List<Cast>> createCasts(@RequestBody List<Cast> casts) {
        return ResponseEntity.ok(service.createCastList(casts));
    }

    @GetMapping("/casts")
    public ResponseEntity<List<Cast>> getCasts() {
        return ResponseEntity.ok(service.getCastList());
    }

    @GetMapping("/casts/{id}")
    public ResponseEntity<Cast> getCastById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCastById(id));
    }

    @PutMapping("/casts")
    public ResponseEntity<Cast> updateCast(@RequestBody Cast cast) {
        return ResponseEntity.ok().body(service.updateCast(cast));
    }

    @PatchMapping("/casts")
    public ResponseEntity<Cast> updateCastPart(@RequestBody Cast cast) {
        return ResponseEntity.ok().body(service.updateCastById(cast));
    }

    @DeleteMapping("/casts/{id}")
    public ResponseEntity<String> deleteCast(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
