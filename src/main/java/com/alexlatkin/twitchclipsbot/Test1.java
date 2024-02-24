package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.controller.VideoClipsController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import com.alexlatkin.twitchclipsbot.service.ClipServiceImpl;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        TwitchService twitchService = new TwitchServiceImpl();

        ClipService clipService = new ClipServiceImpl(twitchService);

        VideoClipsController videoClipsController = new VideoClipsController(clipService);

        List<TwitchClip> twitchClipList = videoClipsController.getClipsByGameName("Dota 2").getData();

        int sum = 0;

        for (TwitchClip twitchClip: twitchClipList) {
            System.out.println(twitchClip);
            sum++;
            System.out.println(twitchClip.getView_count());
        }

        System.out.println(sum);
    }
}
