package com.example.watchMovie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
public class User {

    // comment added
    @Id
    @Column(length = 32)
    private String id;

    @Column
    private String email;
}
