package com.alexlatkin.twitchclipsbot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchClipsDto {

    private List<TwitchClip> data;

    public TwitchClipsDto() {
    }

    public TwitchClipsDto(List<TwitchClip> twitchClips) {
        this.data = twitchClips;
    }

    @Override
    public String toString() {
        return "TwitchClipsDto{" +
                "videoClips=" + data +
                '}';
    }
}
