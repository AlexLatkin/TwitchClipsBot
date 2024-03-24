package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.ButtonCommands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
@Getter
@AllArgsConstructor
public class GameClipsCommand implements BotCommands {
    ClipsController clipsController;
    ButtonCommands buttonCommands;
    Broadcaster broadcaster;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Введите название игры или категории";

        return new SendMessage(chatId, answerText);
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var gameName = update.getMessage().getText();

        String clipUrl;

        String casterName;

        List<TwitchClip> twitchClipsByGameName;

        try {
            twitchClipsByGameName = clipsController.getClipsByGameName(gameName).getData();
        } catch (URISyntaxException e) {
        throw new RuntimeException(e);
        } catch (IOException e) {
        throw new RuntimeException(e);
        } catch (InterruptedException e) {
        throw new RuntimeException(e);
        }

//        try {
//            clipUrl = clipsController.getClipsByGameName(gameName).getData().get(0).getUrl();
//            casterName = clipsController.getClipsByGameName(gameName).getData().get(0).getBroadcasterName();
//
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        clipUrl = twitchClipsByGameName.get(0).getUrl();
        casterName = twitchClipsByGameName.get(0).getBroadcasterName();
        var broadcasterId = twitchClipsByGameName.get(0).getBroadcasterId();


        broadcaster.setBroadcasterName(casterName);
        broadcaster.setBroadcasterId(broadcasterId);

        var msg = new SendMessage(chatId, clipUrl);

        msg.setReplyMarkup(gameClipsCommandKeyboard(casterName));

        return msg;
    }

    public InlineKeyboardMarkup gameClipsCommandKeyboard(String casterName) {

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
