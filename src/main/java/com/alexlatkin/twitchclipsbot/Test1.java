package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.controller.VideoClipsController;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.alexlatkin.twitchclipsbot.service.TwitchVideoClipsService;
import com.alexlatkin.twitchclipsbot.service.VideoClipsService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        TwitchVideoClipsService twitchVideoClipsService = new TwitchVideoClipsService();

        VideoClipsController videoClipsController = new VideoClipsController(twitchVideoClipsService);

        System.out.println(videoClipsController.getUsers("qsnake"));
    }
}
