package com.alexlatkin.twitchclipsbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.URL;


@Data
@Component
public class TwitchApiConfig {
    @Value("https://api.twitch.tv/helix/")
    private String url;
    @Value("${twitchApiConfig.firstHeaderName}")
    private String firstHeaderName;
    @Value("${twitchApiConfig.firstHeaderValue}")
    private String firstHeaderValue;
    @Value("${twitchApiConfig.secondHeaderName}")
    private String secondHeaderName;
    @Value("${twitchApiConfig.secondHeaderValue}")
    private String secondHeaderValue;

}
