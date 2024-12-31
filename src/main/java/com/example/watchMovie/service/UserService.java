package com.example.watchMovie.service;

import com.example.watchMovie.entity.User;
import com.example.watchMovie.exception.IdNotFoundException;
import com.example.watchMovie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);

        if (existingUser != null) {
            return existingUser;
        }

        return userRepository.save(user);
    }

    public List<User> createUserList(List<User> list) {
        return userRepository.saveAll(list);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        Optional<User> userFound = userRepository.findById(user.getId());
        if (userFound.isPresent()) {
            User userUpdate = userFound.get();
            userUpdate.setEmail(user.getEmail());

            return userRepository.save(user);
        } else {
            throw new IdNotFoundException("Invalid User Id");
        }
    }

    public User updateUserById(User user) {
        Optional<User> userFound = userRepository.findById(user.getId());
        if (userFound.isPresent()) {
            User userUpdate = userFound.get();
            if(!user.getEmail().isEmpty())
                userUpdate.setEmail(user.getEmail());

            return userRepository.save(userUpdate);
        } else {
            throw new IdNotFoundException("Invalid User Id");
        }
    }

    public String deleteById(String  id) {
        userRepository.deleteById(id);
        return "User " + id + " is deleted.";
    }

}
