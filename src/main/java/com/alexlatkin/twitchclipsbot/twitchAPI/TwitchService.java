package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchGameDto;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchUser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public interface TwitchService {
    TwitchGameDto getGame(String gameName) throws URISyntaxException, IOException, InterruptedException;
    TwitchUser getBroadcaster(String broadcasterName) throws URISyntaxException, IOException, InterruptedException;
    TwitchClipsDto getClipsByGameId(int gameId, String date) throws IOException, InterruptedException, URISyntaxException;
    CompletableFuture<TwitchClipsDto> getClipsByBroadcastersId(int broadcasterId, String date) throws ExecutionException, InterruptedException, IOException, URISyntaxException;
    TwitchClipsDto getClipsByBroadcasterId(int broadcasterId, String date) throws URISyntaxException, IOException, InterruptedException;
}
