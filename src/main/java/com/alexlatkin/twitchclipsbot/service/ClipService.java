package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


public interface ClipService {
    TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException;
    TwitchClipsDto getClipsByBroadcasterName(String broadcasterName);

    List<TwitchClipsDto> getClipsByBroadcasterNameTest() throws URISyntaxException, IOException, InterruptedException;

}
