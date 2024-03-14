package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@AllArgsConstructor
public class FollowButtonCommand implements ButtonCommands {
    @Override
    public String actionButtonInCurrentMessage(Update update) {
        var messageText = update.getCallbackQuery().getMessage().getText();
        messageText+="\n Вы подписались";
        return messageText;
    }

    @Override
    public InlineKeyboardMarkup keyboard() {
        return null;
    }
}
