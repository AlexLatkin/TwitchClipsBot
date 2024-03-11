package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "name")
    private String userName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_follow_list"
            , joinColumns = @JoinColumn(name = "users_id")
            , inverseJoinColumns = @JoinColumn(name = "follow_list_id"))
    private List<FollowList> followList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "users_black_list"
            , joinColumns = @JoinColumn(name = "users_id")
            , inverseJoinColumns = @JoinColumn(name = "black_list_id"))
    private List<BlackList> blackList;

}
