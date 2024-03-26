package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FollowListClipsCommand implements BotCommands {
    UserController userController;
    ClipsController clipsController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var chatIdString = chatId.toString();
        String answerText = "";

        var userFollowList = userController.getUserFollowListByUserChatId(chatId);

        if (userFollowList == null) {
            answerText = "У вас нет отслеживаемых стримеров";
        } else {

        }

        return new SendMessage(chatIdString, answerText);
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
