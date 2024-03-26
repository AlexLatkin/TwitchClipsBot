package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.entity.Game;
import com.alexlatkin.twitchclipsbot.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    public void addGameByIdAndName(Game game) {
        gameService.addGame(game);
    }
    public Game getGameByGameName(String gameName) {
        return gameService.getGameByGameName(gameName);
    }

    public boolean existsGameByGameName(String gameName) {
        return gameService.existsGameByGameName(gameName);
    }
}
