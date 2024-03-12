package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class BlockButtonCommand implements ButtonCommands {
    @Override
    public String actionButtonInCurrentMessage(Update update) {
        return "Block nooba";
    }

    @Override
    public InlineKeyboardMarkup keyboard() {
        return null;
    }
}
