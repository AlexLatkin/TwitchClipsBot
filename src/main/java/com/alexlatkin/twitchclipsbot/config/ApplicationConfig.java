package com.alexlatkin.twitchclipsbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Bean(name = "qwe")
    public TwitchApiConfig twitchApiConfig() {
        return new TwitchApiConfig();
    }

}
