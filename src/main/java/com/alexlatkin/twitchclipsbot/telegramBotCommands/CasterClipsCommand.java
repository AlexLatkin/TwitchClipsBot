package com.alexlatkin.twitchclipsbot.telegramBotCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

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
}
