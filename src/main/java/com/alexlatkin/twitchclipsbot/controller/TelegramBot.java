package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.config.BotConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig botConfig;

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

            var messageText = update.getMessage();

            var response = new SendMessage();

            response.setChatId(messageText.getChatId().toString());

            response.setText("Hello");

            sendAnswerMessage(response);

    }

    private void sendAnswerMessage(SendMessage message) {
        if(message != null)
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


}
