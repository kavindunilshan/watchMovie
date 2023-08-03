package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class HallId implements Serializable {

    @Column(name = "tid", nullable = false)
    private int tid;

    @Column(name = "hid", nullable = false)
    private int hid;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }
}