package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;


import com.alexlatkin.twitchclipsbot.model.entity.User;
import com.alexlatkin.twitchclipsbot.model.repository.UserRepository;
import com.alexlatkin.twitchclipsbot.service.UserService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class RegisterCommand implements BotCommands {
    UserService userService;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var answerText = "User registered";

       if (!userService.existsUserByChatId(chatId)) {
           var userName = update.getMessage().getChat().getFirstName();
           userService.addUser(chatId, userName);
       }

        var chatIdString = chatId.toString();

        return new SendMessage(chatIdString, answerText);
    }
    @Override
    public BotApiMethod secondMessage(Update update) {
        return null;
    }
}
