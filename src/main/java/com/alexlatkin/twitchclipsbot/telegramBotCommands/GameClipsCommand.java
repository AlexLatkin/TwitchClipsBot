package com.alexlatkin.twitchclipsbot.telegramBotCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.net.URISyntaxException;

@NoArgsConstructor
@AllArgsConstructor
public class GameClipsCommand implements BotCommands {
    ClipsController clipsController;
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

        try {
            clipUrl = clipsController.getClipsByGameName(gameName).getData().get(0).getUrl();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return new SendMessage(chatId, clipUrl);
    }
}
