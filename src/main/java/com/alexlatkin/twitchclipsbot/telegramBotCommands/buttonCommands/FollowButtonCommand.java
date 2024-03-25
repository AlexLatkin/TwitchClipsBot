package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

@Component
@RequiredArgsConstructor
@Setter
public class FollowButtonCommand implements ButtonCommands {
    final UserController userController;
    final BroadcasterController broadcasterController;
    @Override
    public String actionButtonInCurrentMessage(Update update, Broadcaster broadcaster) {
        var messageText = update.getCallbackQuery().getMessage().getText();
        var chatId = update.getCallbackQuery().getMessage().getChatId();

        var bcName = broadcaster.getBroadcasterName();

        if (userController.getUserBlackListByUserChatId(chatId).contains(broadcaster)) {
            messageText+= bcName + " находится у вас в чёрном списке. Для начала удалите " + bcName + " из чёрного списка";
        } else if (userController.getUserFollowListByUserChatId(chatId).contains(broadcaster)) {
            messageText+= " Вы уже подписаны на " + bcName;
        } else if (broadcasterController.existsBroadcasterByBroadcasterName(bcName)) {
            userController.addBroadcasterInUserFollowList(chatId, broadcasterController.getBroadcasterByBroadcasterName(bcName));
            messageText+="\n Вы подписались на " + bcName;
        } else {
            broadcasterController.addBroadcaster(broadcaster);
            userController.addBroadcasterInUserFollowList(chatId, broadcaster);
            messageText+="\n Вы подписались на " + bcName;
        }

        return messageText;
    }
}
