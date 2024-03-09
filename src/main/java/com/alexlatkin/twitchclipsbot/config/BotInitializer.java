package com.alexlatkin.twitchclipsbot.config;


import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.TelegramBot;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.BlockButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.ButtonCommands;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.FollowButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.NextClipButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.*;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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
                                                    ,"/help", new HelpCommand()
                                                    ,"/game_clips", new GameClipsCommand(clipsController)
                                                    ,"/caster_clips", new CasterClipsCommand(clipsController)
                                                    ,"/follow_list_clips", new FollowListClipsCommand()
                                                    ,"/follow_list", new FollowListCommand()
                                                    ,"/black_list", new BlackListCommand());

        Map<String, ButtonCommands> buttonCommands = Map.of("FOLLOW", new FollowButtonCommand()
                                                            ,"BLOCK", new BlockButtonCommand()
                                                            ,"NEXT", new NextClipButtonCommand());

        botConfig.setCommands(commands);
        botConfig.setButtonCommands(buttonCommands);
        telegramBotsApi.registerBot(telegramBot);
    }

}
