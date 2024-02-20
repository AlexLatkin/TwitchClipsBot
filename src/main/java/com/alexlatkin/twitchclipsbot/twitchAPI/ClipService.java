package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.model.TwitchClip;

import java.util.List;

public interface ClipService {
    TwitchClipsDto getClipsByGameName(String gameName);
    TwitchClipsDto getClipsByBroadcasterName(String broadcasterName);
}
