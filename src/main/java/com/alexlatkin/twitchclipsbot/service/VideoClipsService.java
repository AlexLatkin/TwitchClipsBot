package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;

import java.util.List;

public interface VideoClipsService {
    VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId);
    VideoClipsDto getVideoClipsByGameId(Long gameId);
}
