package com.example.watchMovie.repository;

import com.example.watchMovie.entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CastRepository extends JpaRepository<Cast, Integer> {
}
