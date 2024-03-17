package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.model.entity.TestEntity;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import com.alexlatkin.twitchclipsbot.service.TestEntityServ;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
@RequiredArgsConstructor
public class ClipsController {
    private final ClipService clipService;

    private final TestEntityServ testEntityServ;

    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByGameName(gameName);
    }

    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByBroadcasterName(broadcasterName);
    }



    public List<CompletableFuture<String>> getClipsByBroadcasterNameV2() throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        return clipService.getClipsByBroadcastersNames();
    }

    public TestEntity getTest(String name) {
        return testEntityServ.getTestByName(name);
    }
}
