package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;


@AllArgsConstructor
public class FollowListCommand implements BotCommands {
    UserController userController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var userFollowList = userController.getUserFollowListByUserChatId(chatId);

        var bcNames = userFollowList.stream()
                    .map(Broadcaster::getBroadcasterName)
                    .map(e -> e.concat("\n"))
                    .toList()
                    .toString()
                    .replace("[","")
                    .replace("]","")
                    .replace(",","");

        var chatIdString = chatId.toString();

        return new SendMessage(chatIdString, bcNames);
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Команда не поддерживается";

        return new SendMessage(chatId, answerText);
    }
}
