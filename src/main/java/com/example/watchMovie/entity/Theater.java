package com.example.watchMovie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Getter @Setter
@ToString
// @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid")
    private int tid;

    @Column
    private String name;

    @Column
    private String contactNumber;

    @Column
    private String slogan;

    @Column
    private String ratings;

    @Column
    private String dimension;

    @Column
    private String portrait;

    @Column
    private String landscape;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private TheaterLocation location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private List<Hall> halls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private List<TheaterPicture> pictures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private List<SeatData> seatDataList;

    public Theater() {
    }

    public Theater(int tid, String name, String contactNumber, String slogan, String ratings, String dimension, TheaterLocation location, List<Hall> halls, List<TheaterPicture> pictures, List<SeatData> seatDataList) {
        this.tid = tid;
        this.name = name;
        this.contactNumber = contactNumber;
        this.slogan = slogan;
        this.ratings = ratings;
        this.dimension = dimension;
        this.location = location;
        this.halls = halls;
        this.pictures = pictures;
        this.seatDataList = seatDataList;
    }
}
