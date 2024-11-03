package com.example.watchMovie.supportingEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@ToString
public class SeatDataId implements Serializable {
    @Column(name = "tid", nullable = false, length = 30)
    private String  tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid", nullable = false)
    private int mid;

    @Column(name = "slot", nullable = false, length = 8)
    private String timeSlot;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "date", nullable = false, length = 12)
    private String date;



    public SeatDataId() {
    }

    public SeatDataId(String tid, int mid, String timeSlot, String date) {
        this.tid = tid;
        this.mid = mid;
        this.timeSlot = timeSlot;
        this.date = date;
    }
}
