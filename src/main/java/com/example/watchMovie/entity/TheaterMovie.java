package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.MovieId;

import javax.persistence.*;

@Entity
@Table(name="theater_movies")
public class TheaterMovie {
    @EmbeddedId
    private MovieId id;

    @Column
    private int fullPrice;

    @Column
    private int halfPrice;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "mid", insertable = false, updatable = false)
    private Movie movie;

    public int getHalfPrice() {
        return halfPrice;
    }

    public void setHalfPrice(int halfPrice) {
        this.halfPrice = halfPrice;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public MovieId getId() {
        return id;
    }

    public void setId(MovieId id) {
        this.id = id;
    }

    public int getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(int fullPrice) {
        this.fullPrice = fullPrice;
    }

}
