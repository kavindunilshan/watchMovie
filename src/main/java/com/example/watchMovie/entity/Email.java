package com.example.watchMovie.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    private String uid;

    @Column
    private String email;

    @Column
    private String subject;

    @Column
    private String content;

    @Column
    private boolean secure;

    public Email() {
    }

    public Email(int id, String uid, String email, String subject, String content, boolean secure) {
        this.id = id;
        this.uid = uid;
        this.email = email;
        this.subject = subject;
        this.content = content;
        this.secure = secure;
    }
}
