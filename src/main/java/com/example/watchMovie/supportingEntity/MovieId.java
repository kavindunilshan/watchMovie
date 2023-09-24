package com.example.watchMovie.supportingEntity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MovieId implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid", nullable = false)
    private int tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid", nullable = false)
    private int mid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="time_slot", nullable = false, length = 12)
    private String timeSlot;

    public MovieId() {
    }

    public MovieId(int tid, int mid, String timeSlot) {
        this.tid = tid;
        this.mid = mid;
        this.timeSlot = timeSlot;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    @Override
    public String toString() {
        return "MovieId{" +
                "tid=" + tid +
                ", mid=" + mid +
                ", timeSlot='" + timeSlot + '\'' +
                '}';
    }

}
