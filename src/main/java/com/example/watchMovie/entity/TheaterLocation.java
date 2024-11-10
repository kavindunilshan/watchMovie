package com.example.watchMovie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
public class TheaterLocation {
    @Id
    @Column(length = 32)
    private String tid;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String lat;

    @Column
    private String lang;

    @Column
    private String address;
}
