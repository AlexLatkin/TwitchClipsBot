package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClip;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.BlockButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.FollowButtonCommand;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands.commandsWIthAnswer.NextClipButtonCommand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CasterClipsCommand implements BotButtonCommands {
    ClipsController clipsController;
    Broadcaster broadcaster;
    FollowButtonCommand followButtonCommand;
    BlockButtonCommand blockButtonCommand;
    NextClipButtonCommand nextClipButtonCommand;
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

        TwitchClip clip;

        try {
            clip = clipsController.getClipsByBroadcasterName(broadcasterName).getData().get(0);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        var clipUrl = clip.getUrl();

        var msg = new SendMessage(chatId, clipUrl);

        msg.setReplyMarkup(casterClipsCommandKeyboard(broadcasterName));

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
        return nextClipButtonCommand.actionWithMessage(update);
    }

    public InlineKeyboardMarkup casterClipsCommandKeyboard(String casterName) {

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyBoard = new ArrayList<>();
        List<InlineKeyboardButton> buttonLine = new ArrayList<>();
        List<InlineKeyboardButton> secondButtonLine = new ArrayList<>();

        var followButton = new InlineKeyboardButton();
        followButton.setText("Подписаться на " + casterName);
        followButton.setCallbackData("CASTER_CLIPS_FOLLOW");

        var blockButton = new InlineKeyboardButton();
        blockButton.setText("Скрыть " + casterName);
        blockButton.setCallbackData("CASTER_CLIPS_BLOCK");

        var nextClipButton = new InlineKeyboardButton();
        nextClipButton.setText("Следующий клип");
        nextClipButton.setCallbackData("CASTER_CLIPS_NEXT");

        buttonLine.add(followButton);
        buttonLine.add(blockButton);
        secondButtonLine.add(nextClipButton);

        keyBoard.add(buttonLine);
        keyBoard.add(secondButtonLine);

        markupInLine.setKeyboard(keyBoard);

        return  markupInLine;
    }
}
