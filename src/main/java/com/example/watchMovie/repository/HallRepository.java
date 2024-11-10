package com.example.watchMovie.repository;

import com.example.watchMovie.entity.Hall;
import com.example.watchMovie.supportingEntity.HallId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, HallId> {
    // fetch by tid
    List<Hall> findByIdTid(String tid);
}
