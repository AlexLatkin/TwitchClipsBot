package com.alexlatkin.twitchclipsbot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchClipsDto implements Serializable {
    private List<TwitchClip> data;

    @Override
    public String toString() {
        return "TwitchClipsDto{" +
                "data=" + data +
                '}';
    }
}
