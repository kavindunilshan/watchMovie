package com.example.watchMovie.supportingEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@ToString
public class HallId implements Serializable {
    @Column(name = "tid", nullable = false, length = 32)
    private String  tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hid")
    private int hid;

    public HallId() {
    }

    public HallId(String tid, int hid) {
        this.tid = tid;
        this.hid = hid;
    }
}
