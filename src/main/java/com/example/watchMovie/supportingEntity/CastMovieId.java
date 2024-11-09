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
public class CastMovieId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private int cid;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mid")
    private int mid;

    public CastMovieId() {
    }

    public CastMovieId(int mid, int cid) {
        this.cid = cid;
        this.mid = mid;
    }
}
