package com.example.watchMovie.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
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

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<TheaterPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<TheaterPicture> pictures) {
        this.pictures = pictures;
    }


    public List<SeatData> getSeatDataList() {
        return seatDataList;
    }

    public void setSeatDataList(List<SeatData> seatDataList) {
        this.seatDataList = seatDataList;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public TheaterLocation getLocation() {
        return location;
    }

    public void setLocation(TheaterLocation location) {
        this.location = location;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String  getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public void setHalls(List<Hall> halls) {
        this.halls = halls;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
