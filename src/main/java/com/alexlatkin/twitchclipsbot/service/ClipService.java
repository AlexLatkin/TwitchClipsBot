package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public interface ClipService {
    TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException;
    List<CompletableFuture<String>> getClipsByBroadcasterName() throws URISyntaxException, IOException, InterruptedException, ExecutionException;

    List<TwitchClipsDto> getClipsByBroadcasterNameTest() throws URISyntaxException, IOException, InterruptedException;

}
