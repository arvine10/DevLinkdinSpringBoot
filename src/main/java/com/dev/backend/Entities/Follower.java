package com.dev.backend.Entities;

import javax.persistence.*;

@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="beingFollowed_id")
    private Users beingFollowed;


    @ManyToOne
    @JoinColumn(name="follower_id")
    private Users follower;


    public Follower(){}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getBeingFollowed() {
        return beingFollowed;
    }

    public void setBeingFollowed(Users beingFollowed) {
        this.beingFollowed = beingFollowed;
    }

    public Users getFollower() {
        return follower;
    }

    public void setFollower(Users follower) {
        this.follower = follower;
    }
}
