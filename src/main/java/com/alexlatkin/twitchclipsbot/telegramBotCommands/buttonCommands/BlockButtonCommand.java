package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;


@RequiredArgsConstructor
@Component
public class BlockButtonCommand implements ButtonCommands {
    final UserController userController;
    final BroadcasterController broadcasterController;
    @Override
    public String actionButtonInCurrentMessage(Update update, Broadcaster broadcaster) {
        var messageText = update.getCallbackQuery().getMessage().getText();
        var chatId = update.getCallbackQuery().getMessage().getChatId();

        var bcName = broadcaster.getBroadcasterName();

        if (userController.getUserFollowListByUserChatId(chatId).contains(broadcaster)) {
            messageText+= " Вы подписаны на " + bcName + ", сначала отпишитесь";
        } else if (userController.getUserBlackListByUserChatId(chatId).contains(broadcaster)) {
            messageText+= bcName + " уже у вас в чёрном списке";
        } else if (broadcasterController.existsBroadcasterByBroadcasterName(bcName)) {
            userController.addBroadcasterInUserBlackList(chatId, broadcasterController.getBroadcasterByBroadcasterName(bcName));
            messageText+="\n " + bcName + " добавлен в чёрный список";
        } else {
            broadcasterController.addBroadcaster(broadcaster);
            userController.addBroadcasterInUserBlackList(chatId, broadcaster);
            messageText+="\n " + bcName + " добавлен в чёрный список";
        }

        return messageText;
    }

}
