package com.example.watchMovie.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isSecure() {
        return secure;
    }

    public void setSecure(boolean secure) {
        this.secure = secure;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
