package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.entity.Game;

public interface GameService {
    Game getGameByGameName(String gameName);
    void addGame(Integer gameId,String gameName);
    boolean existsGameByGameName(String gameName);
}
