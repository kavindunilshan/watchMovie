package com.example.watchMovie.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int mid;

    @Column
    private String duration;

    @Column
    private String name;

    @Column
    private String actor;

    @Column
    private String actress;

    @Column
    private String director;

    @Column
    private String language;

    @Column
    private String trailer;

    @Column
    private String imdb;

    @Column
    private String genre;

    @Column
    private String dimesion;

    @Column
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getDimesion() {
        return dimesion;
    }

    public void setDimesion(String dimesion) {
        this.dimesion = dimesion;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public List<MovieCast> getCasts() {
        return casts;
    }

    public void setCasts(List<MovieCast> casts) {
        this.casts = casts;
    }

//    @ElementCollection
//    @CollectionTable(name = "pictures", joinColumns = @JoinColumn(name = "mid"))
//    @Column(name = "picture")
//    private List<String> pictures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid")
    private List<Picture> pictures;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid")
    private List<MovieCast> casts;

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

    public String  getDuration() {
        return duration;
    }

    public void setDuration(String  duration) {
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
