package com.example.watchMovie.supportingEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@ToString
public class MovieId implements Serializable {
    @Column(name = "tid", nullable = false, length = 30)
    private String  tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid", nullable = false)
    private int mid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="time_slot", nullable = false, length = 12)
    private String timeSlot;

    public MovieId() {
    }

    public MovieId(String tid, int mid, String timeSlot) {
        this.tid = tid;
        this.mid = mid;
        this.timeSlot = timeSlot;
    }
}
