package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.config.BotConfig;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig botConfig;
//    final ClipsController clipsController;

    final ClipService clipService;

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

            var message = update.getMessage();

            var response = new SendMessage();

            response.setChatId(message.getChatId().toString());

            if (message.getText().contains("/game_clips")) {
                var gameName = message.getText().substring(11);

                String clips = null;
                try {
                    clips = clipService.getClipsByGameName(gameName).getData().get(0).getUrl();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                response.setText(clips);

                sendAnswerMessage(response);
            }




            switch (message.getText()) {
                case "/start":
                            response.setText("Hello");
                            sendAnswerMessage(response);
                            break;
                case "/help":
                            response.setText("some text");
                            sendAnswerMessage(response);
                            break;
//                case "/game_clips":
//                    try {
//                        response.setText(clipsController.getClipsByGameName(update.getMessage().getText()).getData().get(0).getUrl());
//                    } catch (URISyntaxException e) {
//                        throw new RuntimeException(e);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    sendAnswerMessage(response);
//                            break;
                default:
                            response.setText("Команда не поддерживается");
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





}
