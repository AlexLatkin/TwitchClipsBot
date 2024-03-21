package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "name")
    private String userName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_follow_list"
            , joinColumns = @JoinColumn(name = "users_id")
            , inverseJoinColumns = @JoinColumn(name = "bc_id"))
    private List<Broadcaster> followList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_black_list"
            , joinColumns = @JoinColumn(name = "users_id")
            , inverseJoinColumns = @JoinColumn(name = "bc_id"))
    private List<Broadcaster> blackList;

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
