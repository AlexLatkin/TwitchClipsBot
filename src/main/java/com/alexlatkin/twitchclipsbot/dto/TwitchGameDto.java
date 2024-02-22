package com.alexlatkin.twitchclipsbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchGameDto {
    public int id;
    public String name;
    public String boxArtUrl;
    public String igdbId;

    @Override
    public String toString() {
        return "TwitchGameDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", boxArtUrl='" + boxArtUrl + '\'' +
                ", igdbId='" + igdbId + '\'' +
                '}';
    }
}
