package com.alexlatkin.twitchclipsbot.model.entity;

import lombok.Data;

@Data
public class BlackList {

    private String broadcasterName;
    private int broadcasterId;
}
