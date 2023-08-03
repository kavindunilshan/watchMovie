package com.example.watchMovie.repository;

import com.example.watchMovie.entity.Hall;
import com.example.watchMovie.supportingEntity.HallId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall, HallId> {
}
