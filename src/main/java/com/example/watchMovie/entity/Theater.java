package com.example.watchMovie.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
// @JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
public class Theater {
    @Id
    @Column(name = "tid")
    private int tid;

    @Column
    private String name;

    @Column
    private int contactNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private TheaterLocation location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private List<Hall> halls;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "tid")
    private List<TheaterMovie> movies;

    public TheaterLocation getLocation() {
        return location;
    }

    public void setLocation(TheaterLocation location) {
        this.location = location;
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

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<TheaterMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<TheaterMovie> movies) {
        this.movies = movies;
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
