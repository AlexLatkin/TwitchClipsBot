package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.controller.VideoClipsController;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import com.alexlatkin.twitchclipsbot.service.ClipServiceImpl;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        TwitchService twitchService = new TwitchServiceImpl();

        VideoClipsController videoClipsController = new VideoClipsController(twitchService);

        System.out.println(videoClipsController.getGameInfo("Dota 2"));


        ClipService clipService = new ClipServiceImpl(twitchService);

        System.out.println(clipService.getClipsByBroadcasterName("qSnake"));
    }
}
