package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.TicketId;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {
    @EmbeddedId
    private TicketId ticketId;

    @Column
    private int fullSeats;

    @Column
    private String bookedSeats;

    @Column
    private int halfSeats;

    @Column
    private int total;

    public TicketId getTicketId() {
        return ticketId;
    }

    public void setTicketId(TicketId ticketId) {
        this.ticketId = ticketId;
    }

    public int getFullSeats() {
        return fullSeats;
    }

    public void setFullSeats(int fullSeats) {
        this.fullSeats = fullSeats;
    }

    public int getHalfSeats() {
        return halfSeats;
    }

    public void setHalfSeats(int halfSeats) {
        this.halfSeats = halfSeats;
    }

    public String getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(String bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", fullSeats=" + fullSeats +
                ", halfSeats=" + halfSeats +
                ", total=" + total +
                '}';
    }
}
