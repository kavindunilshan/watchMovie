package com.example.watchMovie.controller;

import com.example.watchMovie.entity.User;
import com.example.watchMovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(this.service.createUser(user));
    }

    @PostMapping("/list")
    public ResponseEntity<List<User>> createUsers(@RequestBody List<User> users) {
        return ResponseEntity.ok(service.createUserList(users));
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        System.out.println("#################################");
        System.out.println("Get Users");
        System.out.println("#################################");
        return ResponseEntity.ok(service.getUserList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PutMapping("")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return ResponseEntity.ok().body(service.updateUser(user));
    }

    @PatchMapping("")
    public ResponseEntity<User> updateUserPart(@RequestBody User user) {
        return ResponseEntity.ok().body(service.updateUserById(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteById(id));
    }

}
