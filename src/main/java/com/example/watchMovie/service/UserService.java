package com.example.watchMovie.service;

import com.example.watchMovie.entity.User;
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
        return userRepository.save(user);
    }

    public List<User> createUserList(List<User> list) {
        return userRepository.saveAll(list);
    }

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        Optional<User> userFound = userRepository.findById(user.getId());
        if (userFound.isPresent()) {
            User userUpdate = userFound.get();
            userUpdate.setFname(user.getFname());
            userUpdate.setLname(user.getLname());
            userUpdate.setAge(user.getAge());
            userUpdate.setDistrict(user.getDistrict());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setPassword(user.getPassword());

            return userRepository.save(user);
        } else {
            return null;
        }
    }

    public String deleteById(int id) {
        userRepository.deleteById(id);
        return "User " + id + " is deleted.";
    }

}
