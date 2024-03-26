package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.entity.Game;
import com.alexlatkin.twitchclipsbot.model.repository.GameRepository;
import com.alexlatkin.twitchclipsbot.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    @Transactional
    @Override
    public boolean existsGameByGameName(String gameName) {
        return gameRepository.existsGameByGameName(gameName);
    }
    @Transactional
    @Override
    public Game getGameByGameName(String gameName) {
        return gameRepository.findGameByGameName(gameName);
    }
    @Transactional
    @Override
    public void addGame(Game game) {
        gameRepository.save(game);
    }
}
