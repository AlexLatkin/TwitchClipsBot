package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class ClipServiceImpl implements ClipService {
    private final TwitchService twitchService;

    @Override
    public TwitchClipsDto getClipsByGameName(String gameName) {
        return null;
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);



        return null;
    }
}
