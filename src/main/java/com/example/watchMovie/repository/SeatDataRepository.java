package com.example.watchMovie.repository;

import com.example.watchMovie.entity.SeatData;
import com.example.watchMovie.supportingEntity.SeatDataId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatDataRepository extends JpaRepository<SeatData, SeatDataId> {
}
