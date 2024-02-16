package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwitchVideoClipsService implements VideoClipsService {
    @Override
    public VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId) {
        return null;
    }

    @Override
    public VideoClipsDto getVideoClipsByGameId(Long gameId) {
        return null;
    }
}
