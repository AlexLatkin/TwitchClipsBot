package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public interface ButtonCommands {
    String actionButtonInCurrentMessage(Update update);
    String actionButtonWithNextMessage(Update update);
}
