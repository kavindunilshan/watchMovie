package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.PictureId;

import javax.persistence.*;

@Entity
@Table(name="pictures")
public class Picture {
    @EmbeddedId
    private PictureId id;

    @Column(nullable = false)
    private String name;

    public PictureId getId() {
        return id;
    }

    public void setId(PictureId id) {
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
        return "Picture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
