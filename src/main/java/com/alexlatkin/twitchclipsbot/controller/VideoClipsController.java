package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import com.alexlatkin.twitchclipsbot.model.VideoClip;
import com.alexlatkin.twitchclipsbot.service.VideoClipsService;
import lombok.RequiredArgsConstructor;
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
    public List<VideoClip> getVideoClipsByGameName(String gameName) throws IOException, URISyntaxException, InterruptedException {
        return videoClipsService.getVideoClipsByGameName(gameName);
    }

    public int getUserId(String broadcasterName) throws IOException, InterruptedException, URISyntaxException {
        return videoClipsService.getBroadcasterId(broadcasterName);
    }

    public int getGameId(String gameName) throws URISyntaxException, IOException, InterruptedException {
        return videoClipsService.getGameId(gameName);
    }
}
