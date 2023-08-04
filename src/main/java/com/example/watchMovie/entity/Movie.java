package com.example.watchMovie.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @Column
    private int mid;

    @Column
    private int duration;

    @Column
    private String name;

    @Column
    private String actor;

    @Column
    private String actress;

    @Column
    private String director;

//    @ElementCollection
//    @CollectionTable(name = "pictures", joinColumns = @JoinColumn(name = "mid"))
//    @Column(name = "picture")
//    private List<String> pictures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid")
    private List<Picture> pictures;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "mid=" + mid +
                ", duration=" + duration +
                ", name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", actress='" + actress + '\'' +
                ", director='" + director + '\'' +
                ", pictures=" + pictures +
                '}';
    }
}
