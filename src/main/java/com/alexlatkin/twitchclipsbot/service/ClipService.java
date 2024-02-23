package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;


public interface ClipService {
    TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException;
    TwitchClipsDto getClipsByBroadcasterName(String broadcasterName);

}
