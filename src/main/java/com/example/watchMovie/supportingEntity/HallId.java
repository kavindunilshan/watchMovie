package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class HallId implements Serializable {

    @Column(name = "tid")
    private int tid;

    @Column(name = "hid")
    private int hid;

    public HallId() {
    }

    public HallId(int tid, int hid) {
        this.tid = tid;
        this.hid = hid;
    }

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

    @Override
    public String toString() {
        return "HallId{" +
                "tid=" + tid +
                ", hid=" + hid +
                '}';
    }
}
