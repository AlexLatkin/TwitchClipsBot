package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.config.TwitchApiConfig;
import com.alexlatkin.twitchclipsbot.controller.VideoClipsController;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchVideoClipsService;
import com.alexlatkin.twitchclipsbot.twitchAPI.UserService;
import com.alexlatkin.twitchclipsbot.twitchAPI.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.URISyntaxException;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

//        TwitchVideoClipsService twitchVideoClipsService = new TwitchVideoClipsService();
//
//        VideoClipsController videoClipsController = new VideoClipsController(twitchVideoClipsService);
//
//        System.out.println(videoClipsController.getUserId("qsnake"));
//        System.out.println(videoClipsController.getGameId("Dota 2"));
//
//        System.out.println(videoClipsController.getVideoClipsByGameName("Dota 2"));

        UserService userService = new UserServiceImpl();

        VideoClipsController videoClipsController = new VideoClipsController(userService);

        System.out.println(videoClipsController.getUser("qsnake").getId());

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

//        TwitchApiConfig twitchApiConfig = new TwitchApiConfig();
//
//        System.out.println(twitchApiConfig);




    }
}
