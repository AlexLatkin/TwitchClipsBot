package com.alexlatkin.twitchclipsbot.config;


import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.TelegramBot;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.BlockButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.FollowButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer.NextClipButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BotInitializer {
    final TelegramBot telegramBot;
    final BotConfig botConfig;
    final TelegramCommands telegramCommands;
    final FollowButtonCommand followButtonCommand;
    final BlockButtonCommand blockButtonCommand;
    final NextClipButtonCommand nextClipButtonCommand;
    final ClipsController clipsController;
    final UserController userController;
    final BroadcasterController broadcasterController;
    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        GameClipsCommand gameClipsCommand = new GameClipsCommand(clipsController, new Broadcaster()
                                                                , followButtonCommand, blockButtonCommand, nextClipButtonCommand
                                                                , new ArrayList<TwitchClip>());

        CasterClipsCommand casterClipsCommand = new CasterClipsCommand(clipsController, new Broadcaster()
                                                                    , followButtonCommand, blockButtonCommand, nextClipButtonCommand
                                                                    , new ArrayList<TwitchClip>());

        Map<String, BotCommands> textCommands = Map.of("/start", new RegisterCommand(userController)
                                                    ,"/help", new HelpCommand(userController, broadcasterController, clipsController)
                                                    ,"/game_clips", gameClipsCommand
                                                    ,"/caster_clips", casterClipsCommand
                                                    ,"/follow_list_clips", new FollowListClipsCommand(userController, clipsController)
                                                    ,"/follow_list", new FollowListCommand(userController)
                                                    ,"/black_list", new BlackListCommand(userController));

        Map<String, BotButtonCommands> followCommands = Map.of("GAME_CLIPS_FOLLOW", gameClipsCommand
                                                        ,"CASTER_CLIPS_FOLLOW", casterClipsCommand);

        Map<String, BotButtonCommands> blockCommands = Map.of("GAME_CLIPS_BLOCK", gameClipsCommand
                                                       ,"CASTER_CLIPS_BLOCK", casterClipsCommand);

        Map<String, BotButtonCommands> nextCommands = Map.of("GAME_CLIPS_NEXT", gameClipsCommand
                                                      ,"CASTER_CLIPS_NEXT", casterClipsCommand);

        telegramCommands.setTextCommands(textCommands);
        telegramCommands.setFollowButtonCommands(followCommands);
        telegramCommands.setBlockButtonCommands(blockCommands);
        telegramCommands.setNextButtonCommands(nextCommands);
        botConfig.setTelegramCommands(telegramCommands);
        telegramBotsApi.registerBot(telegramBot);
    }

}
