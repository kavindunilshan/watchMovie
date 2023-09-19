package com.example.watchMovie.controller;

import com.example.watchMovie.entity.TheaterPicture;
import com.example.watchMovie.service.TheaterPictureService;
import com.example.watchMovie.supportingEntity.TheaterPictureId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TheaterPictureController {
    @Autowired
    private TheaterPictureService service;

    @PostMapping("/theaterPictures")
    public ResponseEntity<TheaterPicture> createTheaterPicture(@RequestBody TheaterPicture theaterPicture) {
        System.out.println(theaterPicture);
        return ResponseEntity.ok(this.service.createTheaterPicture(theaterPicture));
    }

    @PostMapping("/theaterPicturesList")
    public ResponseEntity<List<TheaterPicture>> createTheaterPictures(@RequestBody List<TheaterPicture> theaterPictures) {
        return ResponseEntity.ok(service.createTheaterPictureList(theaterPictures));
    }

    @GetMapping("/theaterPictures")
    public ResponseEntity<List<TheaterPicture>> getTheaterPictures() {
        return ResponseEntity.ok(service.getTheaterPictureList());
    }

    @GetMapping("/theaterPictures/{mid}/{pid}")
    public ResponseEntity<TheaterPicture> getTheaterPictureById(@PathVariable int mid, @PathVariable int pid) {
        TheaterPictureId id = new TheaterPictureId(mid, pid);
        return ResponseEntity.ok(service.getTheaterPictureById(id));
    }

    @PutMapping("/theaterPictures")
    public ResponseEntity<TheaterPicture> updateTheaterPicture(@RequestBody TheaterPicture theaterPicture) {
        return ResponseEntity.ok().body(service.updateTheaterPicture(theaterPicture));
    }

    @PatchMapping("/theaterPictures")
    public ResponseEntity<TheaterPicture> updateTheaterPicturePart(@RequestBody TheaterPicture theaterPicture) {
        return ResponseEntity.ok().body(service.updateTheaterPictureById(theaterPicture));
    }

    @DeleteMapping("/theaterPictures/{mid}/{pid}")
    public ResponseEntity<String> deleteTheaterPicture(@PathVariable int mid, @PathVariable int pid) {
        TheaterPictureId id = new TheaterPictureId(mid, pid);
        return ResponseEntity.ok(service.deleteById(id));
    }

}
