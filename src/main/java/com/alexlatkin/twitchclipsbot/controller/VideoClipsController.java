package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import com.alexlatkin.twitchclipsbot.service.VideoClipsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
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

    public TwitchUser getUsers(String broadcasterName) throws IOException, InterruptedException, URISyntaxException {
        return videoClipsService.getUsers(broadcasterName);
    }
}
