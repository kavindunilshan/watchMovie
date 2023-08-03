package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.MovieId;

import javax.persistence.*;

@Entity
@Table(name="theater_movies")
public class TheaterMovie {
    @EmbeddedId
    private MovieId id;

    @Column
    private int price;

    @Column
    private String timeSlot;

    @Column
    private String dimension;

    public MovieId getId() {
        return id;
    }

    public void setId(MovieId id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }
}
