package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.HallId;

import javax.persistence.*;

@Entity
@Table
public class Hall {
    @EmbeddedId
    private HallId id;

    @Column
    private int seats;

    public HallId getId() {
        return id;
    }

    public void setId(HallId id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
