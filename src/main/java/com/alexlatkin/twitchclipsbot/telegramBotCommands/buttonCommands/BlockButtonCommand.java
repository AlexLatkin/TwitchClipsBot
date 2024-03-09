package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import org.telegram.telegrambots.meta.api.objects.Update;

public class BlockButtonCommand implements ButtonCommands {
    @Override
    public String actionButtonInCurrentMessage(Update update) {
        return "Block nooba";
    }

    @Override
    public String actionButtonWithNextMessage(Update update) {
        return null;
    }
}
