package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.BotCommands;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpCommand implements BotCommands {
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Some text";

        return new SendMessage(chatId, answerText);
    }
    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Command not required";

        return new SendMessage(chatId, answerText);
    }
}
