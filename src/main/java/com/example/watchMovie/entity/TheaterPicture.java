package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.TheaterPictureId;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="theaterPictures")
public class TheaterPicture {
    @EmbeddedId
    private TheaterPictureId id;

    @Column(nullable = false)
    private String name;

    public TheaterPictureId getId() {
        return id;
    }

    public void setId(TheaterPictureId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TheaterPicture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
