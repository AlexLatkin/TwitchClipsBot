package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import com.alexlatkin.twitchclipsbot.service.VideoClipsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VideoClipsController {
    private final VideoClipsService videoClipsService;

    public VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId) {
        return videoClipsService.getVideoClipsByBroadcastersId(BroadcasterId);
    }
    public VideoClipsDto getVideoClipsByGameId(Long gameId) {
        return videoClipsService.getVideoClipsByGameId(gameId);
    }
}
