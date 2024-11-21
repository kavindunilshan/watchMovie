package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.PictureId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="pictures")
@Getter
@Setter
@ToString
public class Picture {
    @EmbeddedId
    private PictureId id;

    @Column(nullable = false)
    private String name;

}
