package com.example.watchMovie.supportingEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@ToString
public class TicketId implements Serializable {
    @Column(name = "tid", nullable = false, length = 30)
    private String  tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int tc_id;

    public TicketId() {
    }

    public TicketId(String tid, int tc_id) {
        this.tid = tid;
        this.tc_id = tc_id;
    }
}