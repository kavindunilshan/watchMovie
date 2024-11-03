package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.SeatDataId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter @Setter
@ToString
public class SeatData {
    @EmbeddedId
    private SeatDataId id;

    @Column
    private int numSeats;

    @Column
    private String seats;

    @Column
    private int hid;
}
