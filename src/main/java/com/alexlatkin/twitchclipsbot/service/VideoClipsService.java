package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface VideoClipsService {
    VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId);
    VideoClipsDto getVideoClipsByGameId(Long gameId);
    Long getGames(String gameName);
    TwitchUser getUsers(String broadcasterName) throws IOException, InterruptedException, URISyntaxException;
}
