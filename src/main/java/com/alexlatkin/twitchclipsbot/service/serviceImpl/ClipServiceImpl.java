package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.service.BroadcasterService;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import com.alexlatkin.twitchclipsbot.service.GameService;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class ClipServiceImpl implements ClipService {
    private final TwitchService twitchService;
    private final GameService gameService;
    private final BroadcasterService broadcasterService;

    @Override
    @Cacheable("gameClips")
    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var gameId = 0;

        if (gameService.existsGameByGameName(gameName)) {
            gameId = gameService.getGameByGameName(gameName).getGameId();
        } else {
            gameId = twitchService.getGame(gameName).getId();
            gameService.addGame(gameId, gameName);
        }

        return twitchService.getClipsByGameId(gameId, date);
    }

    @Override
    public List<CompletableFuture<String>> getClipsByBroadcasterName() throws URISyntaxException, IOException, InterruptedException, ExecutionException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var broadcasterId = twitchService.getBroadcaster("qsnake").getId();
        var broadcasterId2 = twitchService.getBroadcaster("madarapoe").getId();
        var broadcasterId3 = twitchService.getBroadcaster("mariachi").getId();

        List<Integer> list = new ArrayList<>();
        list.add(broadcasterId3);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);
        list.add(broadcasterId2);

        List<CompletableFuture<String>> allClips = new ArrayList<>();

        long startTime = System.nanoTime();


        list.stream().forEach(bcID -> {
            try {
                allClips.add(twitchService.getClipsByBroadcastersId(bcID, date));
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });


        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        System.out.println(duration);


        CompletableFuture.allOf(allClips.toArray(new CompletableFuture[0])).get();

        return allClips;
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) throws URISyntaxException, IOException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var broadcasterId = 0;

        if (broadcasterService.existsBroadcasterByBroadcasterName(broadcasterName)) {
            broadcasterId = broadcasterService.getBroadcasterByBroadcasterName(broadcasterName).getBroadcasterId();
        } else {
            broadcasterId = twitchService.getBroadcaster(broadcasterName).getId();
            broadcasterService.addBroadcaster(broadcasterId, broadcasterName);
        }

        return twitchService.getClipsByBroadcasterId(broadcasterId, date);
    }
}
