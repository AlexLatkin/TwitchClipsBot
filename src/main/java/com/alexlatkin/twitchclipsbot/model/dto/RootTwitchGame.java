package com.alexlatkin.twitchclipsbot.model.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class RootTwitchGame {
    public ArrayList<TwitchGameDto> data;
}
