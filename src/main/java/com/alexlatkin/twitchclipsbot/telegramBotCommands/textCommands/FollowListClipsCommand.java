package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
public class FollowListClipsCommand implements BotCommands {
    UserController userController;
    ClipsController clipsController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId();
        var chatIdString = chatId.toString();
        String answerText = "";

        var userFollowList = userController.getUserFollowListByUserChatId(chatId);
        List<CompletableFuture<TwitchClipsDto>> clips = new ArrayList<>();

        if (userFollowList == null) {
            answerText = "У вас нет отслеживаемых стримеров";
        } else {
            try {
                clips = clipsController.getClipsByUserFollowList(userFollowList);
                answerText = clips.get(0).get().getData().get(0).getUrl();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        
        return new SendMessage(chatIdString, answerText);
    }

    @Override
    public BotApiMethod secondMessage(Update update) {
        return null;
    }

    public InlineKeyboardMarkup followListClipsCommandKeyboard(String casterName) {

        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyBoard = new ArrayList<>();
        List<InlineKeyboardButton> buttonLine = new ArrayList<>();

        var nextClipButton = new InlineKeyboardButton();
        nextClipButton.setText("Следующий клип");
        nextClipButton.setCallbackData("NEXT");

        buttonLine.add(nextClipButton);

        keyBoard.add(buttonLine);

        markupInLine.setKeyboard(keyBoard);

        return  markupInLine;
    }
}
