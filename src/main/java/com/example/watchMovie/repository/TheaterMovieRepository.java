package com.example.watchMovie.repository;

import com.example.watchMovie.entity.TheaterMovie;
import com.example.watchMovie.supportingEntity.MovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterMovieRepository extends JpaRepository<TheaterMovie, MovieId> {
}
