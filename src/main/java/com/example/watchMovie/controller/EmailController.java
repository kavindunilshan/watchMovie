package com.example.watchMovie.controller;

import com.example.watchMovie.entity.Email;
import com.example.watchMovie.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmailController {
    @Autowired
    private EmailService service;

    @PostMapping("/emails")
    public ResponseEntity<Email> createEmail(@RequestBody Email email) {
        return ResponseEntity.ok(this.service.createEmail(email));
    }

    @GetMapping("/emails")
    public ResponseEntity<List<Email>> getEmails() {
        return ResponseEntity.ok(service.getEmailList());
    }

    @GetMapping("/emails/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable int id) {
        return ResponseEntity.ok(service.getEmailById(id));
    }
    
    @DeleteMapping("/emails/{id}")
    public ResponseEntity<String> deleteEmail(@PathVariable int id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
