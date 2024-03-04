package com.alexlatkin.twitchclipsbot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "black_list")
public class BlackList {

    @Id
    @Column(name = "broadcaster_name")
    private String broadcasterName;
    @Column(name = "broadcaster_id")
    private int broadcasterId;

    @ManyToMany
    @JoinTable(name = "user_black_list"
            , joinColumns = @JoinColumn(name = "black_list_id")
            , inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
