package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@AllArgsConstructor
public class HelpCommand implements BotCommands {
    UserController userController;
    BroadcasterController broadcasterController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Описание команд";

        return new SendMessage(chatId, answerText);
    }
    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Команда не поддерживается";





//        Broadcaster broadcasterTest = new Broadcaster();
//        broadcasterTest.setBroadcasterId(6);
//        broadcasterTest.setBroadcasterName("Qwqe");
//        broadcasterController.addBroadcaster(broadcasterTest);

        var bc = broadcasterController.getBroadcasterByBroadcasterName("snessh");


        userController.deleteBroadcasterFromUserFollowList(update.getMessage().getChatId(), bc);
//
//        broadcasterController.addBroadcaster(broadcasterTest.getBroadcasterId(), broadcasterTest.getBroadcasterName());
//
//        userController.addBroadcasterInUserFollowList(update.getMessage().getChatId(), broadcasterTest.getBroadcasterId());

        return new SendMessage(chatId, answerText);
    }
}
