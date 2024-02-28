package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequiredArgsConstructor
public class VideoClipsController {
    private final ClipService clipService;

    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByGameName(gameName);
    }

    public List<TwitchClipsDto> getClipsByBroadcasterName() throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByBroadcasterNameTest();
    }



    public List<CompletableFuture<String>> getClipsByBroadcasterNameV2() throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        return clipService.getClipsByBroadcasterName();
    }
}
