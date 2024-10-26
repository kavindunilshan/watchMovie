package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
public class TheaterPictureId implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid", nullable = false)
    private int tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid", nullable = false)
    private int pid;

    public TheaterPictureId() {
    }

    public TheaterPictureId(int tid, int pid) {
        this.tid = tid;
        this.pid = pid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "PictureId{" +
                "tid=" + tid +
                ", pid=" + pid +
                '}';
    }
}
