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

    public MovieId() {
    }

    public MovieId(int tid, int mid) {
        this.tid = tid;
        this.mid = mid;
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

    @Override
    public String toString() {
        return "MovieId{" +
                "tid=" + tid +
                ", mid=" + mid +
                '}';
    }

}
