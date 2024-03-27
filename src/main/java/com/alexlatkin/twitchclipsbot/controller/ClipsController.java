package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
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
public class ClipsController {
    private final ClipService clipService;

    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByGameName(gameName);
    }

    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) throws URISyntaxException, IOException, InterruptedException {
        return clipService.getClipsByBroadcasterName(broadcasterName);
    }

    public List<CompletableFuture<TwitchClipsDto>> getClipsByUserFollowList(List<Broadcaster> userFollowList) throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        return clipService.getClipsByUserFollowList(userFollowList);
    }

    public CompletableFuture<TwitchClipsDto> test(int bcId, String date) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        return clipService.test(bcId, date);
    }
}
