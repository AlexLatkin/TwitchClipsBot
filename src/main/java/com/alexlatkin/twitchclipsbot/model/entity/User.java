package com.alexlatkin.twitchclipsbot.model.entity;


import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "user")
public class User {
    @Id
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "name")
    private String userName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_favorite_list"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "favorite_list_id"))
    private List<FavoriteList> favoriteList;

    @ManyToMany
    @JoinTable(name = "user_black_list"
            , joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "black_list_id"))
    private List<BlackList> blackList;

}
