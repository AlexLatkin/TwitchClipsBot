package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);



        return null;
    }

    @Override
    public List<TwitchClipsDto> getClipsByBroadcasterNameTest() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        List<Integer> broadcasterId = new ArrayList<>();
        broadcasterId.add(40594834);
        broadcasterId.add(72556476);
        broadcasterId.add(34932688);
        broadcasterId.add(72556476);
        broadcasterId.add(72556476);
        broadcasterId.add(44335356);
        broadcasterId.add(676585166);
        broadcasterId.add(108268890);
        broadcasterId.add(108268890);
        broadcasterId.add(128430795);
        broadcasterId.add(108268890);
        broadcasterId.add(108268890);
        broadcasterId.add(49440419);
        broadcasterId.add(49440419);
        broadcasterId.add(450012016);
        broadcasterId.add(108268890);
        broadcasterId.add(676585166);
        broadcasterId.add(21379187);
        broadcasterId.add(128430795);
        broadcasterId.add(40754777);


        long startTime = System.nanoTime();


        List<TwitchClipsDto> list = broadcasterId.stream().map(e -> {
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

        return list;
    }
}
