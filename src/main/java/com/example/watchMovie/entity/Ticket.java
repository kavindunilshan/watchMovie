package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.TicketId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
@Getter
@Setter
@ToString
public class Ticket {
    @EmbeddedId
    private TicketId ticketId;

    @Column
    private int uid;

    @Column
    private int mid;

    @Column
    private int full;

    @Column
    private String slot;

    @Column
    private String date;

    @Column
    private int half;

    @Column
    private String bookedSeats;

    @Column
    private int total;
}
