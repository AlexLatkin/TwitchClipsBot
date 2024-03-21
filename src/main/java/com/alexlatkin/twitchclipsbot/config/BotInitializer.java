package com.alexlatkin.twitchclipsbot.config;


import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.TelegramBot;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.repository.UserRepository;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.BlockButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.ButtonCommands;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.FollowButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer.ButtonCommandsWithAnswer;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer.NextClipButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BotInitializer {
    final TelegramBot telegramBot;
    final BotConfig botConfig;
    final ClipsController clipsController;
    final UserController userController;
    final BroadcasterController broadcasterController;
    @EventListener({ContextRefreshedEvent.class})
    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        Map<String, BotCommands> commands = Map.of("/start", new RegisterCommand(userController)
                                                    ,"/help", new HelpCommand(userController, broadcasterController)
                                                    ,"/game_clips", new GameClipsCommand(clipsController)
                                                    ,"/caster_clips", new CasterClipsCommand(clipsController)
                                                    ,"/follow_list_clips", new FollowListClipsCommand()
                                                    ,"/follow_list", new FollowListCommand(userController)
                                                    ,"/black_list", new BlackListCommand(userController));

        Map<String, ButtonCommands> buttonCommands = Map.of("FOLLOW", new FollowButtonCommand()
                                                            ,"BLOCK", new BlockButtonCommand());

        Map<String, ButtonCommandsWithAnswer> buttonCommandsWithAnswer = Map.of("NEXT", new NextClipButtonCommand());

        botConfig.setCommands(commands);
        botConfig.setButtonCommands(buttonCommands);
        botConfig.setButtonCommandsWithAnswer(buttonCommandsWithAnswer);
        telegramBotsApi.registerBot(telegramBot);
    }

}
