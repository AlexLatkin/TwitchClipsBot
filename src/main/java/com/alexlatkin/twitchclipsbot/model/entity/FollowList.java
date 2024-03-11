package com.alexlatkin.twitchclipsbot.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "follow_list")
public class FollowList {
    @Id
    @Column(name = "broadcaster_id")
    private Integer broadcasterId;
    @Column(name = "broadcaster_name")
    private String broadcasterName;
    @ManyToMany(mappedBy = "followList")
//    @JoinTable(name = "users_follow_list"
//            , joinColumns = @JoinColumn(name = "follow_list_id")
//            , inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<User> users;
}
