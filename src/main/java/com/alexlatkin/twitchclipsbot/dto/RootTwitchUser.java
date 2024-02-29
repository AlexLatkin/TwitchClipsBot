package com.alexlatkin.twitchclipsbot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class RootTwitchUser {
    public ArrayList<TwitchUser> data;
}
