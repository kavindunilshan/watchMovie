package com.example.watchMovie.supportingEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@ToString
public class TheaterPictureId implements Serializable {
    @Column(name = "tid", nullable = false, length = 30)
    private String  tid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pid", nullable = false)
    private int pid;

    public TheaterPictureId() {
    }

    public TheaterPictureId(String tid, int pid) {
        this.tid = tid;
        this.pid = pid;
    }
}
