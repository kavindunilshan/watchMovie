package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PictureId implements Serializable {
    @Column(name = "mid", nullable = false)
    private int mid;

    @Column(name = "pid", nullable = false)
    private int pid;

    public PictureId(int mid, int pid) {
        this.mid = mid;
        this.pid = pid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
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
                "mid=" + mid +
                ", pid=" + pid +
                '}';
    }
}
