package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer;

import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.ButtonCommands;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class NextClipButtonCommand implements ButtonCommandsWithAnswer {

    @Override
    public String actionWithMessage(Update update) {
        return "Hi";
    }

    public InlineKeyboardMarkup keyboard() {

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
