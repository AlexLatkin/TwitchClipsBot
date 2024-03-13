package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ButtonCommandsWithAnswer {
    String actionWithMessage(Update update);
}
