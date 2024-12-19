package com.example.watchMovie.repository;

import com.example.watchMovie.entity.MovieCast;
import com.example.watchMovie.supportingEntity.CastMovieId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieCastRepository extends JpaRepository<MovieCast, CastMovieId> {
}
