package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return chatId.equals(user.chatId) && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, userName);
    }
}
