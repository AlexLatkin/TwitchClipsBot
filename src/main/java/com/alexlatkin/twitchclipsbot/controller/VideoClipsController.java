package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;


@RestController
@RequiredArgsConstructor
public class VideoClipsController {
    private final TwitchService twitchService;
    public TwitchGameDto getGameInfo(String gameName) throws URISyntaxException, IOException, InterruptedException {
        return twitchService.getGame(gameName);
    }
}
