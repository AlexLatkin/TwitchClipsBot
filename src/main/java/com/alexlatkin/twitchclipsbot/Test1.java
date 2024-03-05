package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
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

public class Test1 {
    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException, ExecutionException {

//        TwitchService twitchService = new TwitchServiceImpl();
//
//        ClipService clipService = new ClipServiceImpl(twitchService);
//
//        ClipsController clipsController = new ClipsController(clipService);
//
//        List<TwitchClip> twitchClipList = clipsController.getClipsByGameName("Dota 2").getData();

//        int sum = 0;
//
//        for (TwitchClip twitchClip: twitchClipList) {
//            System.out.println(twitchClip);
//            sum++;
//            System.out.println(twitchClip.getView_count());
//        }
//
//        System.out.println(sum);


//        List<TwitchClipsDto> twitchClips2 = clipsController.getClipsByBroadcasterName();
//
//        System.out.println(twitchClips2.get(0).getData());
//
//        List<CompletableFuture<String>> sdad = clipsController.getClipsByBroadcasterNameV2();
//
//
//
//        System.out.println(sdad.get(0).get());
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

