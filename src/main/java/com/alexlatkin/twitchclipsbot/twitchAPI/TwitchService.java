package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;

import java.io.IOException;
import java.net.URISyntaxException;


public interface TwitchService {
    TwitchGameDto getGame(String gameName) throws URISyntaxException, IOException, InterruptedException;
    TwitchUser getBroadcaster(String broadcasterName) throws URISyntaxException, IOException, InterruptedException;
    TwitchClipsDto getClipsByGameName(String gameName, String date);
    TwitchClipsDto getClipsByBroadcasterName(String broadcasterName, String date);
}
