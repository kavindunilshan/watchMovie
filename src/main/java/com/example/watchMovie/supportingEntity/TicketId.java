package com.example.watchMovie.supportingEntity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class TicketId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid", nullable = false)
    private int tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int tc_id;

    public TicketId() {
    }

    public TicketId(int tid, int tc_id) {
        this.tid = tid;
        this.tc_id = tc_id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getTc_id() {
        return tc_id;
    }

    public void setTc_id(int tc_id) {
        this.tc_id = tc_id;
    }

    @Override
    public String toString() {
        return "TicketId{" +
                "tid=" + tid +
                ", tc_id=" + tc_id +
                '}';
    }
}