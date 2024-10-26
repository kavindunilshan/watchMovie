package com.example.watchMovie.repository;


import com.example.watchMovie.entity.TheaterLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterLocationRepository extends JpaRepository<TheaterLocation, Integer> {
}
