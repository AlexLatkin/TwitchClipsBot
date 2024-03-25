package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.BotCommands;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class FollowListClipsCommand implements BotCommands {
    @Override
    public BotApiMethod firstMessage(Update update) {
        return null;
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        return null;
    }

    public InlineKeyboardMarkup followListClipsCommandKeyboard(String casterName) {

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyBoard = new ArrayList<>();
        List<InlineKeyboardButton> buttonLine = new ArrayList<>();

        var nextClipButton = new InlineKeyboardButton();
        nextClipButton.setText("Следующий клип");
        nextClipButton.setCallbackData("NEXT");

        buttonLine.add(nextClipButton);

        keyBoard.add(buttonLine);

        markupInLine.setKeyboard(keyBoard);

        return  markupInLine;
    }
}
