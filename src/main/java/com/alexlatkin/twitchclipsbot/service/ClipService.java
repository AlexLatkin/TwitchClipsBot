package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;
import org.springframework.stereotype.Service;


public interface ClipService {
    TwitchClipsDto getClipsByGameName(String gameName);
    TwitchClipsDto getClipsByBroadcasterName(String broadcasterName);

}
