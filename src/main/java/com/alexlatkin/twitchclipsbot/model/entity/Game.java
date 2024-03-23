package com.alexlatkin.twitchclipsbot.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "game")
public class Game {
    @Id
    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "game_name")
    private String gameName;
    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                '}';
    }
}
