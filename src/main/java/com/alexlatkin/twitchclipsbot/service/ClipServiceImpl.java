package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.jvm.internal.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClipServiceImpl implements ClipService {
    private final TwitchService twitchService;

    @Override
    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var gameId = twitchService.getGame(gameName).getId();

        return twitchService.getClipsByGameId(gameId, date);
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) throws URISyntaxException, IOException, InterruptedException, ExecutionException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var broadcasterId = twitchService.getBroadcaster("qsnake").getId();
        var broadcasterId2 = twitchService.getBroadcaster("madarapoe").getId();

        List<Integer> list = new ArrayList<>();
        list.add(broadcasterId);
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


        List<CompletableFuture<String>> allClips = list.stream().map(bc -> {
            try {
                return twitchService.getClipsByBroadcasterName(bc, date);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        allClips.stream().map(CompletableFuture::join);


        allClips.get(0).get();


        ObjectMapper mapper = new ObjectMapper();

        TwitchClipsDto twitchClipsDto;


        return twitchClipsDto;
    }

    @Override
    public List<TwitchClipsDto> getClipsByBroadcasterNameTest() throws URISyntaxException, IOException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var broadcasterId = twitchService.getBroadcaster("qsnake").getId();
        var broadcasterId2 = twitchService.getBroadcaster("madarapoe").getId();

        List<Integer> list = new ArrayList<>();
        list.add(broadcasterId);
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

        long startTime = System.nanoTime();

        List<TwitchClipsDto> twitchClipsDtos = list.stream().map(e -> {
            try {
                return twitchService.getClipsByBroadcasterNameTest(e, date);
            } catch (URISyntaxException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }).collect(Collectors.toList());

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        System.out.println(duration);


        return twitchClipsDtos;
    }
}
