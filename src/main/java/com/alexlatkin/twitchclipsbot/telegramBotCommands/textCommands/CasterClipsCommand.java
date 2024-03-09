package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.BotCommands;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CasterClipsCommand implements BotCommands {

    ClipsController clipsController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Введите ник стримера";

        return new SendMessage(chatId, answerText);
    }
    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var broadcasterName = update.getMessage().getText();

        String clipUrl;

//         clipUrl = clipsController.getClipsByBroadcasterName().get(0).getData().get(0).getUrl();


        return null;
    }

    public InlineKeyboardMarkup casterClipsCommandKeyboard(String casterName) {

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyBoard = new ArrayList<>();
        List<InlineKeyboardButton> buttonLine = new ArrayList<>();
        List<InlineKeyboardButton> secondButtonLine = new ArrayList<>();

        var followButton = new InlineKeyboardButton();
        followButton.setText("Подписаться на " + casterName);
        followButton.setCallbackData("FOLLOW");

        var blockButton = new InlineKeyboardButton();
        blockButton.setText("Скрыть " + casterName);
        blockButton.setCallbackData("BLOCK");

        var nextClipButton = new InlineKeyboardButton();
        nextClipButton.setText("Следующий клип");
        nextClipButton.setCallbackData("NEXT");

        buttonLine.add(followButton);
        buttonLine.add(blockButton);
        secondButtonLine.add(nextClipButton);

        keyBoard.add(buttonLine);
        keyBoard.add(secondButtonLine);

        markupInLine.setKeyboard(keyBoard);

        return  markupInLine;
    }
}
