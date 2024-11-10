package com.example.watchMovie.repository;

import com.example.watchMovie.entity.TheaterMovie;
import com.example.watchMovie.supportingEntity.MovieId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterMovieRepository extends JpaRepository<TheaterMovie, MovieId> {
    List<TheaterMovie> findAllById_Tid(String tid);
}
