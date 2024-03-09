package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NextClipButtonCommand implements ButtonCommands {
    @Override
    public String actionButtonInCurrentMessage(Update update) {
        return null;
    }

    @Override
    public String actionButtonWithNextMessage(Update update) {
        return "Hello";
    }
}
