package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;

public interface GameService {
    TwitchGameDto getGame(String gameName);
}
