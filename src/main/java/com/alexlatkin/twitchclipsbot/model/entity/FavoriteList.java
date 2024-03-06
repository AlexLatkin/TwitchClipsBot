package com.alexlatkin.twitchclipsbot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "favorite_list")
public class FavoriteList {
    @Id
    @Column(name = "broadcaster_id")
    private int broadcasterId;
    @Column(name = "broadcaster_name")
    private String broadcasterName;
    @ManyToMany
    @JoinTable(name = "user_favorite_list"
            , joinColumns = @JoinColumn(name = "favorite_list_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
