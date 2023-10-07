package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.TicketId;

import javax.persistence.*;

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

    public TicketId getTicketId() {
        return ticketId;
    }

    public void setTicketId(TicketId ticketId) {
        this.ticketId = ticketId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getFull() {
        return full;
    }

    public void setFull(int full) {
        this.full = full;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHalf() {
        return half;
    }

    public void setHalf(int half) {
        this.half = half;
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
                ", uid=" + uid +
                ", mid=" + mid +
                ", full=" + full +
                ", slot='" + slot + '\'' +
                ", date='" + date + '\'' +
                ", half=" + half +
                ", bookedSeats='" + bookedSeats + '\'' +
                ", total=" + total +
                '}';
    }
}
