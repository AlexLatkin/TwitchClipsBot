package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class VideoClipsController {
    private final ClipService clipService;

    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByGameName(gameName);
    }

    public List<TwitchClipsDto> getClipsByBroadcasterName() {
        return clipService.getClipsByBroadcasterNameTest();
    }
}
