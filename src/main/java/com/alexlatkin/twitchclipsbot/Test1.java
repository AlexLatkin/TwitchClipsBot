package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.controller.VideoClipsController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import com.alexlatkin.twitchclipsbot.service.ClipServiceImpl;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchServiceImpl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ExecutionException {

        TwitchService twitchService = new TwitchServiceImpl();

        ClipService clipService = new ClipServiceImpl(twitchService);

        VideoClipsController videoClipsController = new VideoClipsController(clipService);

        List<TwitchClip> twitchClipList = videoClipsController.getClipsByGameName("Dota 2").getData();

//        int sum = 0;
//
//        for (TwitchClip twitchClip: twitchClipList) {
//            System.out.println(twitchClip);
//            sum++;
//            System.out.println(twitchClip.getView_count());
//        }
//
//        System.out.println(sum);


        List<TwitchClipsDto> twitchClips2 = videoClipsController.getClipsByBroadcasterName();

        System.out.println(twitchClips2.get(11).getData());

        List<CompletableFuture<String>> sdad = videoClipsController.getClipsByBroadcasterNameV2();



        System.out.println(sdad.get(11).get());
//
//
//
//        long endTime = System.nanoTime();
//
//        long duration = (endTime - startTime);
//
//        System.out.println(duration);
    }
}

