package com.example.watchMovie.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

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
    @Override
    public String toString() {
        return "Theater{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
