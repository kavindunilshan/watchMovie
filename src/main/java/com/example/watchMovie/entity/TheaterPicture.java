package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.TheaterPictureId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="theaterPictures")
@Getter
@Setter
@ToString
public class TheaterPicture {
    @EmbeddedId
    private TheaterPictureId id;

    @Column(nullable = false)
    private String name;
}
