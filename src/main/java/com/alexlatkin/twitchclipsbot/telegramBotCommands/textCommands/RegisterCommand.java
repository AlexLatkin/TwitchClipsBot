package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;


import com.alexlatkin.twitchclipsbot.model.entity.User;
import com.alexlatkin.twitchclipsbot.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class RegisterCommand implements BotCommands {

    final UserRepository userRepository;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var answerText = "Hi";

       if (userRepository.findById(chatId).isEmpty()) {
           User user = new User();
           user.setChatId(chatId);
           user.setUserName(update.getMessage().getChat().getFirstName());
           userRepository.save(user);
       }

        return new SendMessage(chatId.toString(), answerText);
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        return null;
    }
}
