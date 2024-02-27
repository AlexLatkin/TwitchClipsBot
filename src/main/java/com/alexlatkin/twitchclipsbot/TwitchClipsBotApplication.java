package com.alexlatkin.twitchclipsbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TwitchClipsBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitchClipsBotApplication.class, args);
    }

}
