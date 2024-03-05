package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.config.BotConfig;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
@AllArgsConstructor
@RestController
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig botConfig;
    final ClipsController clipsController;

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

            var userMessageText = update.getMessage().getText();

            var response = new SendMessage();

            response.setChatId(update.getMessage().getChatId().toString());

            if(userMessageText.contains("/start")) {
                response.setText("Start command");

                sendAnswerMessage(response);
            }

            if(userMessageText.contains("/help")) {
            response.setText("Help command");

            sendAnswerMessage(response);
            }

            if (userMessageText.contains("/game_clips")) {

                var gameName = userMessageText.substring(12);

                String clips = getClipsByGameName(gameName);

                response.setText(clips);

                sendAnswerMessage(response);
            }


    }

    private void sendAnswerMessage(SendMessage message) {
        if(message != null)
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private String getClipsByGameName(String gameName) {
        try {
            return clipsController.getClipsByGameName(gameName).getData().get(0).getUrl();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
