package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.model.TwitchClip;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface VideoClipsService {
    TwitchClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId);
    List<TwitchClip> getVideoClipsByGameName(String gameName) throws IOException, InterruptedException, URISyntaxException;
    int getGameId(String gameName) throws URISyntaxException, IOException, InterruptedException;
    int getBroadcasterId(String broadcasterName) throws IOException, InterruptedException, URISyntaxException;
}
