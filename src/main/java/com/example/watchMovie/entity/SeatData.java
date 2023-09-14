package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.SeatDataId;

import javax.persistence.*;

@Entity
@Table
public class SeatData {
    @EmbeddedId
    private SeatDataId id;

    @Column
    private int numSeats;

    @Column
    private String seats;

    public SeatData() {
    }

    public SeatData(SeatDataId id, int numSeats, String seats) {
        this.id = id;
        this.numSeats = numSeats;
        this.seats = seats;
    }

    public SeatDataId getId() {
        return id;
    }

    public void setId(SeatDataId id) {
        this.id = id;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "SeatData{" +
                "id=" + id +
                ", numSeats=" + numSeats +
                ", seats='" + seats + '\'' +
                '}';
    }
}
