package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.BlockButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.ButtonCommands;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.FollowButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer.NextClipButtonCommand;
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
public class GameClipsCommand implements BotButtonCommands {
    ClipsController clipsController;
    Broadcaster broadcaster;
    FollowButtonCommand followButtonCommand;
    BlockButtonCommand blockButtonCommand;
    NextClipButtonCommand nextClipButtonCommand;
    List<TwitchClip> clipList;
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

        try {
            clipList = clipsController.getClipsByGameName(gameName).getData();
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

        clipUrl = clipList.get(0).getUrl();
        casterName = clipList.get(0).getBroadcasterName();
        var broadcasterId = clipList.get(0).getBroadcasterId();


        broadcaster.setBroadcasterName(casterName);
        broadcaster.setBroadcasterId(broadcasterId);

        var msg = new SendMessage(chatId, clipUrl);

        msg.setReplyMarkup(gameClipsCommandKeyboard(casterName));

        return msg;
    }

    @Override
    public String clickFollowButton(Update update) {
        return followButtonCommand.actionButtonInCurrentMessage(update, broadcaster);
    }

    @Override
    public String clickBlockButton(Update update) {
        return blockButtonCommand.actionButtonInCurrentMessage(update, broadcaster);
    }

    @Override
    public String clickNextButton(Update update) {
        return nextClipButtonCommand.actionWithMessage(update, clipList);
    }

    public InlineKeyboardMarkup gameClipsCommandKeyboard(String casterName) {

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyBoard = new ArrayList<>();
        List<InlineKeyboardButton> buttonLine = new ArrayList<>();
        List<InlineKeyboardButton> secondButtonLine = new ArrayList<>();

        var followButton = new InlineKeyboardButton();
        followButton.setText("Подписаться на " + casterName);
        followButton.setCallbackData("GAME_CLIPS_FOLLOW");

        var blockButton = new InlineKeyboardButton();
        blockButton.setText("Скрыть " + casterName);
        blockButton.setCallbackData("GAME_CLIPS_BLOCK");

        var nextClipButton = new InlineKeyboardButton();
        nextClipButton.setText("Следующий клип");
        nextClipButton.setCallbackData("GAME_CLIPS_NEXT");

        buttonLine.add(followButton);
        buttonLine.add(blockButton);
        secondButtonLine.add(nextClipButton);

        keyBoard.add(buttonLine);
        keyBoard.add(secondButtonLine);

        markupInLine.setKeyboard(keyBoard);

        return  markupInLine;
    }
}
