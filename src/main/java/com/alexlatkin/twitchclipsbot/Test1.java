package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.controller.VideoClipsController;
import com.alexlatkin.twitchclipsbot.twitchAPI.ClipService;
import com.alexlatkin.twitchclipsbot.twitchAPI.ClipServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        ClipService clipService = new ClipServiceImpl();

        VideoClipsController videoClipsController = new VideoClipsController(clipService);

        System.out.println(videoClipsController.getGameInfo("Dota 2"));
    }
}
