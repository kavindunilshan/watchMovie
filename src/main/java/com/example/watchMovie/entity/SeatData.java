package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.MovieId;
import com.example.watchMovie.supportingEntity.SeatDataId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="seat_data")
@NoArgsConstructor
@AllArgsConstructor
public class SeatData {
    @EmbeddedId
    private SeatDataId id;

    @Column
    private int numSeats;

    @Column
    private String seats;

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
}
