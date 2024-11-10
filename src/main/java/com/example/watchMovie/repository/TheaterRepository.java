package com.example.watchMovie.repository;

import com.example.watchMovie.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, String> {
}
