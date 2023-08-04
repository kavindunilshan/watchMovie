package com.example.watchMovie.supportingEntity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class TicketId implements Serializable {

    @Column(name = "tid", nullable = false)
    private int tid;

    @Column(name = "id", nullable = false)
    private int id;

    public TicketId(int tid, int id) {
        this.tid = tid;
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
