package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.CastMovieId;
import com.example.watchMovie.supportingEntity.HallId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class MovieCast {
    @EmbeddedId
    private CastMovieId id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "tid"), @JoinColumn(name = "hid")})
    private List<TheaterMovie> movies;

    public CastMovieId getId() {
        return id;
    }

    public void setId(CastMovieId id) {
        this.id = id;
    }

    public List<TheaterMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<TheaterMovie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieCast{" +
                "id=" + id +
                ", movies=" + movies +
                '}';
    }
}
