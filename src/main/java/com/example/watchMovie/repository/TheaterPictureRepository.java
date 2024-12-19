package com.example.watchMovie.repository;

import com.example.watchMovie.entity.TheaterPicture;
import com.example.watchMovie.supportingEntity.TheaterPictureId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterPictureRepository extends JpaRepository<TheaterPicture, TheaterPictureId> {
}
