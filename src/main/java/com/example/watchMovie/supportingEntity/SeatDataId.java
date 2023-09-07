package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
public class SeatDataId implements Serializable {
    @Column(name = "tid", nullable = false)
    private int tid;

    @Column(name = "mid", nullable = false)
    private int mid;

    @Column(name = "slot", nullable = false)
    private String timeSlot;

    @Column(name = "date", nullable = false)
    private String date;



    public SeatDataId() {
    }

    public SeatDataId(int tid, int mid, String timeSlot, String date) {
        this.tid = tid;
        this.mid = mid;
        this.timeSlot = timeSlot;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "SeatDataId{" +
                "tid=" + tid +
                ", mid=" + mid +
                ", timeSlot='" + timeSlot + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
