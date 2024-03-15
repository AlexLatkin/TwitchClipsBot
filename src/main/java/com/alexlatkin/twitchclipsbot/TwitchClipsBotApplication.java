package com.alexlatkin.twitchclipsbot;

import com.alexlatkin.twitchclipsbot.model.repository.TestRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class TwitchClipsBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitchClipsBotApplication.class, args);
    }


    @Bean
    public ApplicationRunner applicationRunner(TestRepo testRepo) {
        return args -> {
            System.out.println(testRepo.findTestEntitiesByName("Eva"));
        };
    }

}
