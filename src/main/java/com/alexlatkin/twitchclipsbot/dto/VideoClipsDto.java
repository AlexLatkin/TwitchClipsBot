package com.alexlatkin.twitchclipsbot.dto;

import com.alexlatkin.twitchclipsbot.model.VideoClip;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoClipsDto {
    private List<VideoClip> videoClips;
}
