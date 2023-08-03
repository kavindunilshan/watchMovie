package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.TicketId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tickets")
public class Ticket {
    @EmbeddedId
    private TicketId ticketId;

    @Column
    private int uid;

    @Column
    private int mid;

    @Column
    private int fullSeats;

    @Column
    private int halfSeats;

    @Column
    private String bookedSeats;

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

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", uid=" + uid +
                ", fullSeats=" + fullSeats +
                ", bookedSeats='" + bookedSeats + '\'' +
                ", halfSeats=" + halfSeats +
                ", total=" + total +
                '}';
    }
}
