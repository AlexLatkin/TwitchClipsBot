package com.alexlatkin.twitchclipsbot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchClip implements Serializable {
    public String url;
    @JsonProperty("broadcaster_id")
    public int broadcasterId;
    @JsonProperty("broadcaster_name")
    public String broadcasterName;
}
