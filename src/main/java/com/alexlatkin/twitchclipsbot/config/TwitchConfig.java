package com.alexlatkin.twitchclipsbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("classpath:application.properties")
public class TwitchConfig {
    @Value("${twitchConfig.url}")
    private String url;
    @Value("${twitchConfig.firstHeaderName}")
    private String firstHeaderName;
    @Value("${twitchConfig.firstHeaderValue}")
    private String firstHeaderValue;
    @Value("${twitchConfig.secondHeaderName}")
    private String secondHeaderName;
    @Value("${twitchConfig.secondHeaderValue}")
    private String secondHeaderValue;

}
