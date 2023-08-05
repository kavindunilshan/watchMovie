package com.example.watchMovie.entity;

import javax.persistence.*;

@Entity
@Table
public class TheaterLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int tid;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String lat;

    @Column
    private String lang;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "TheaterLocation{" +
                "tid=" + tid +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", lat='" + lat + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
