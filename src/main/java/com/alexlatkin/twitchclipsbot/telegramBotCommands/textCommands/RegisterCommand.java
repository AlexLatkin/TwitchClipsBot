package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.entity.User;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class RegisterCommand implements BotCommands {
    final UserController userController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var answerText = "User registered";

        if (!userController.existsUserByChatId(chatId)) {
            var userName = update.getMessage().getChat().getFirstName();
            User user = new User();
            user.setChatId(chatId);
            user.setUserName(userName);
            userController.addUser(user);
        }

        var chatIdString = chatId.toString();

        return new SendMessage(chatIdString, answerText);
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Command not required";

        return new SendMessage(chatId, answerText);
    }
}
