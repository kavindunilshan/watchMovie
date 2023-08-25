package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
public class CastMovieId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private int cid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid")
    private int mid;

    public CastMovieId() {
    }

    public CastMovieId(int tid, int hid) {
        this.cid = tid;
        this.mid = hid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "HallId{" +
                "cid=" + cid +
                ", mid=" + mid +
                '}';
    }
}
