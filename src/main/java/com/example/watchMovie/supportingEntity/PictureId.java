package com.example.watchMovie.supportingEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PictureId implements Serializable {
    @Column(name = "mid", nullable = false)
    private int mid;

    @Column(name = "id", nullable = false)
    private int id;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PictureId{" +
                "mid=" + mid +
                ", id=" + id +
                '}';
    }
}
