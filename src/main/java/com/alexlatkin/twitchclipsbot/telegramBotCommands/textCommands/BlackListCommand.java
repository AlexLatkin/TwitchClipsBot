package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class BlackListCommand implements BotCommands {
    UserController userController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var userFollowList = userController.getUserBlackListByUserChatId(chatId).toString();
        var chatIdString = chatId.toString();

        return new SendMessage(chatIdString, userFollowList);
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Команда не поддерживается";

        return new SendMessage(chatId, answerText);
    }
}
