package com.alexlatkin.twitchclipsbot.model.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class RootTwitchUser {
    public ArrayList<TwitchUser> data;
}
