package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;


import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
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
        var name = update.getMessage().getText();

        var answerText = clipsController.getTest(name).toString();

        return new SendMessage(chatId, answerText);
    }
}
