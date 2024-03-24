package com.alexlatkin.twitchclipsbot.telegramBotCommands.buttonCommands;

import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands.GameClipsCommand;
import lombok.AllArgsConstructor;
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
    public String actionButtonInCurrentMessage(Update update) {
        var messageText = update.getCallbackQuery().getMessage().getText();
        var chatId = update.getCallbackQuery().getMessage().getChatId();


//        if (broadcasterController.existsBroadcasterByBroadcasterName(broadcaster.getBroadcasterName())) {
//            userController.addBroadcasterInUserFollowList(chatId, broadcasterController.getBroadcasterByBroadcasterName(broadcaster.getBroadcasterName()));
//        } else {
//            broadcasterController.addBroadcaster(broadcaster);
//            userController.addBroadcasterInUserFollowList(chatId, broadcaster);
//        }
//
//        messageText+="\n Вы подписались на " + broadcaster.getBroadcasterName();
        return messageText;
    }

    @Override
    public InlineKeyboardMarkup keyboard() {
        return null;
    }
}
