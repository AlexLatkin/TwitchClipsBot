package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface VideoClipsService {
    VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId);
    VideoClipsDto getVideoClipsByGameId(Long gameId);
    int getGameId(String gameName) throws URISyntaxException, IOException, InterruptedException;
    int getBroadcasterId(String broadcasterName) throws IOException, InterruptedException, URISyntaxException;
}
