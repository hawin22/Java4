package com.example.assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Favorites", uniqueConstraints={
        @UniqueConstraint(columnNames = {"VideoId" , "UserId"})
})
public class Favorite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @ManyToOne @JoinColumn(name = "userid")
    User user;

    @ManyToOne @JoinColumn(name = "videoid")
    Video video;

    @Temporal(TemporalType.DATE)
    Date likedate = new Date();

    public Favorite(User user, Video video) {
        this.user = user;
        this.video = video;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getLikedate() {
        return likedate;
    }

    public void setLikedate(Date likedate) {
        this.likedate = likedate;
    }

}
