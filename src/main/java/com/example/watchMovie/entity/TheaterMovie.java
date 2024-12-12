package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.MovieId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="theater_movies")
@Getter
@Setter
@ToString
public class TheaterMovie {
    @EmbeddedId
    private MovieId id;

    @Column
    private int fullPrice;

    @Column
    private int halfPrice;

    @Column
    private int hid;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "mid", insertable = false, updatable = false)
    private Movie movie;
}
