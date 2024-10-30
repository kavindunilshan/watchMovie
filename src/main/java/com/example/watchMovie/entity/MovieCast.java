package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.CastMovieId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@ToString
public class MovieCast {
    @EmbeddedId
    private CastMovieId id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "tid"), @JoinColumn(name = "hid")})
    private List<TheaterMovie> movies;
}
