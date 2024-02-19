package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import com.alexlatkin.twitchclipsbot.model.VideoClip;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface VideoClipsService {
    VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId);
    List<VideoClip> getVideoClipsByGameName(String gameName) throws IOException, InterruptedException, URISyntaxException;
    int getGameId(String gameName) throws URISyntaxException, IOException, InterruptedException;
    int getBroadcasterId(String broadcasterName) throws IOException, InterruptedException, URISyntaxException;
}
