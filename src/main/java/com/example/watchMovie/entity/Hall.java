package com.example.watchMovie.entity;

import com.example.watchMovie.supportingEntity.HallId;
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

}
