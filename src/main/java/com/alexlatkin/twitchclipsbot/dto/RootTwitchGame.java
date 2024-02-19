package com.alexlatkin.twitchclipsbot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
public class RootTwitchGame {
    public ArrayList<TwitchGameDto> data;

    @Override
    public String toString() {
        return "RootTwitchGame{" +
                "date=" + data +
                '}';
    }
}
