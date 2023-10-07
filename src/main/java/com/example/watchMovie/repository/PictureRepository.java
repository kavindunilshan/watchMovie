package com.example.watchMovie.repository;

import com.example.watchMovie.entity.Picture;
import com.example.watchMovie.supportingEntity.PictureId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, PictureId> {
}
