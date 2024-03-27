package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

public interface ButtonCommandsWithAnswer {
    String actionWithMessage(Update update, List<TwitchClip> clipList);
}
