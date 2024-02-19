package com.alexlatkin.twitchclipsbot.dto;

import com.alexlatkin.twitchclipsbot.model.VideoClip;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoClipsDto {

    private List<VideoClip> data;

    public VideoClipsDto() {
    }

    public VideoClipsDto(List<VideoClip> videoClips) {
        this.data = videoClips;
    }

    @Override
    public String toString() {
        return "VideoClipsDto{" +
                "videoClips=" + data +
                '}';
    }
}
