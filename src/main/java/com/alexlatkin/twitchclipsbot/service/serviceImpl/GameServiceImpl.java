package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.entity.Game;
import com.alexlatkin.twitchclipsbot.model.repository.GameRepository;
import com.alexlatkin.twitchclipsbot.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    @Override
    public boolean existsGameByGameName(String gameName) {
        return gameRepository.existsGameByGameName(gameName);
    }

    @Override
    public Game getGameByGameName(String gameName) {
        return gameRepository.findGameByGameName(gameName);
    }

    @Override
    public void addGame(Integer gameId,String gameName) {
        Game game = new Game();
        game.setGameId(gameId);
        game.setGameName(gameName);
        gameRepository.save(game);
    }
}
