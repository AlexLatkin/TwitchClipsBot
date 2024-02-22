package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;

import java.io.IOException;
import java.net.URISyntaxException;


public interface ClipService {
    TwitchGameDto getGame(String gameName) throws URISyntaxException, IOException, InterruptedException;
    TwitchUser getBroadcaster(String broadcasterName) throws URISyntaxException, IOException, InterruptedException;
    TwitchClipsDto getClipsByGameName(String gameName);
    TwitchClipsDto getClipsByBroadcasterName(String broadcasterName);
}
