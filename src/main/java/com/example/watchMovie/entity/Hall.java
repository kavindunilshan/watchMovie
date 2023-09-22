package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.HallId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Hall {
    @EmbeddedId
    private HallId id;

    @Column
    private int seats;

    @Column
    private int nrows;

    @Column
    private int columns;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "tid"), @JoinColumn(name = "hid")})
    private List<TheaterMovie> movies;

    public int getNrows() {
        return nrows;
    }

    public void setNrows(int nrows) {
        this.nrows = nrows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public HallId getId() {
        return id;
    }

    public void setId(HallId id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public List<TheaterMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<TheaterMovie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", seats=" + seats +
                ", movies=" + movies +
                '}';
    }
}
