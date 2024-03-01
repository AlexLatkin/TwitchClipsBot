package com.alexlatkin.twitchclipsbot.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class RootTwitchUser {
    public ArrayList<TwitchUser> data;

    @Override
    public String toString() {
        return "RootTwitchUser{" +
                "data=" + data +
                '}';
    }
}
