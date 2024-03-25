package com.alexlatkin.twitchclipsbot.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TwitchGameDto {

    public int id;

    public String name;
}
