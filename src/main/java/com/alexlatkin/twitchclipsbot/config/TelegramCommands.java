package com.alexlatkin.twitchclipsbot.config;

import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.BotButtonCommands;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.BotCommands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class TelegramCommands {
    private Map<String, BotCommands> textCommands;
    private Map<String, BotButtonCommands> followButtonCommands;
    private Map<String, BotButtonCommands> blockButtonCommands;
    private Map<String, BotButtonCommands> nextButtonCommands;
}
