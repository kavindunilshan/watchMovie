package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Picture;
import com.example.watchMovie.service.PictureService;
import com.example.watchMovie.supportingEntity.PictureId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PictureController {
    @Autowired
    private PictureService service;

    @PostMapping("/addPicture")
    public ResponseEntity<Picture> createPicture(@RequestBody Picture picture) {
        System.out.println(picture);
        return ResponseEntity.ok(this.service.createPicture(picture));
    }

    @PostMapping("/addPictures")
    public ResponseEntity<List<Picture>> createPictures(@RequestBody List<Picture> pictures) {
        return ResponseEntity.ok(service.createPictureList(pictures));
    }

    @GetMapping("/pictures")
    public ResponseEntity<List<Picture>> getPictures() {
        return ResponseEntity.ok(service.getPictureList());
    }

    @GetMapping("/pictures/{id}")
    public ResponseEntity<Picture> getPictureById(@PathVariable PictureId id) {
        return ResponseEntity.ok(service.getPictureById(id));
    }

    @PutMapping("/updatePicture")
    public ResponseEntity<Picture> updatePicture(@RequestBody Picture picture) {
        return ResponseEntity.ok().body(service.updatePictureById(picture));
    }

    @DeleteMapping("/deletePicture/{id}")
    public ResponseEntity<String> deletePicture(@PathVariable PictureId id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
