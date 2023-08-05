package com.example.watchMovie.supportingEntity;

import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class MovieId implements Serializable {
    private HallId hallId;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid", nullable = false)
    private int mid;

    public MovieId() {
    }

    public MovieId(HallId hallId, int mid) {
        this.hallId = hallId;
        this.mid = mid;
    }

    public HallId getHallId() {
        return hallId;
    }

    public void setHallId(HallId hallId) {
        this.hallId = hallId;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "MovieId{" +
                "hallId=" + hallId +
                ", mid=" + mid +
                '}';
    }
}
