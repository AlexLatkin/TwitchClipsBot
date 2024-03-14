package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;


import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements BotCommands {

    ClipsController clipsController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Введите айди";

        return new SendMessage(chatId, answerText);
    }
    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = clipsController.getTest(update.getMessage().getText()).toString();

        return new SendMessage(chatId, answerText);
    }
}
