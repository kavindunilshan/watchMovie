package com.example.watchMovie.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="movies")
@Getter @Setter
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

    @Column
    private String portrait;

    @Column
    private String landscape;

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
