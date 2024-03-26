package com.alexlatkin.twitchclipsbot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchClipsDto extends CompletableFuture<TwitchClipsDto> implements Serializable {
    private List<TwitchClip> data;

    public static TwitchClipsDto parser(String s) {
        var twitchClipsDto = new TwitchClipsDto();


        return twitchClipsDto;
    }
    @Override
    public String toString() {
        return "TwitchClipsDto{" +
                "data=" + data +
                '}';
    }
}
