package com.alexlatkin.twitchclipsbot.config;


import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.ButtonCommands;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer.ButtonCommandsWithAnswer;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.BotCommands;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Map;

@Data
@Configuration
@PropertySource("classpath:application.properties")
public class BotConfig {
    @Value("${bot.name}")
    private String name;
    @Value("${bot.token}")
    private String token;
    private TelegramCommands telegramCommands;
}
