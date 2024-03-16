package com.alexlatkin.twitchclipsbot.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "game")
public class Game {
    @Id
    @Column(name = "game_id")
    private Integer gameId;
    @Column(name = "game_name")
    private String gameName;
}
