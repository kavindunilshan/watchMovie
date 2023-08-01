package com.example.watchMovie.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Theater {
    @Id
    @Column
    private int tid;

    @Column
    private String name;

    @Column
    private int contactNumber;

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
