package com.alexlatkin.twitchclipsbot.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {
    @Id
    @Column(name = "chat_id")
    private Long chatId;
    @Column(name = "name")
    private String userName;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "users_favorite_list"
//            , joinColumns = @JoinColumn(name = "users_id")
//            , inverseJoinColumns = @JoinColumn(name = "favorite_list_id"))
//    private List<FavoriteList> favoriteList;
//
//    @ManyToMany
//    @JoinTable(name = "users_black_list"
//            , joinColumns = @JoinColumn(name = "users_id")
//            , inverseJoinColumns = @JoinColumn(name = "black_list_id"))
//    private List<BlackList> blackList;

}
