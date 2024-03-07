package com.alexlatkin.twitchclipsbot.config;


import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.TelegramBot;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.*;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

@Component
@AllArgsConstructor
public class BotInitializer {
    final TelegramBot telegramBot;
    final BotConfig botConfig;
    final ClipsController clipsController;

    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        Map<String, BotCommands> commands = Map.of("/start", new RegisterCommand()
                                                , "/help", new HelpCommand()
                                                , "/game_clips", new GameClipsCommand(clipsController)
                                                , "/caster_clips", new BroadcasterClipsCommand(clipsController));

        botConfig.setCommands(commands);
        telegramBotsApi.registerBot(telegramBot);
    }

}
