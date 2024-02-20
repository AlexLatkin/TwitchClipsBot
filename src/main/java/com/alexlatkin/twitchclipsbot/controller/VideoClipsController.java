package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.alexlatkin.twitchclipsbot.model.TwitchClip;
import com.alexlatkin.twitchclipsbot.twitchAPI.UserService;
import com.alexlatkin.twitchclipsbot.twitchAPI.VideoClipsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VideoClipsController {
//    private final VideoClipsService videoClipsService;

    private final UserService userService;

//    public TwitchClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId) {
//        return videoClipsService.getVideoClipsByBroadcastersId(BroadcasterId);
//    }
//    public List<TwitchClip> getVideoClipsByGameName(String gameName) throws IOException, URISyntaxException, InterruptedException {
//        return videoClipsService.getVideoClipsByGameName(gameName);
//    }
//
//    public int getUserId(String broadcasterName) throws IOException, InterruptedException, URISyntaxException {
//        return videoClipsService.getBroadcasterId(broadcasterName);
//    }
//
//    public int getGameId(String gameName) throws URISyntaxException, IOException, InterruptedException {
//        return videoClipsService.getGameId(gameName);
//    }

    public TwitchUser getUser(String userName) throws URISyntaxException, IOException, InterruptedException {
        return userService.getUser("qsnake");
    }
}
