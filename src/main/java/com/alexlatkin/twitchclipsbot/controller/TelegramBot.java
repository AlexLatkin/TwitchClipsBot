package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.config.BotConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Component
public class TelegramBot extends TelegramLongPollingBot {
    final BotConfig botConfig;
    final Map<String, String> chatIdAndUserMessage;
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

        if (update.hasMessage()) {
            var userMessageText = update.getMessage().getText();
            var chatId = update.getMessage().getChatId().toString();

            if (botConfig.getCommands().containsKey(userMessageText)) {
                var response = botConfig.getCommands().get(userMessageText).firstMessage(update);
                chatIdAndUserMessage.put(chatId, userMessageText);
                sendAnswerMessage(response);

            } else if (chatIdAndUserMessage.containsKey(chatId)) {
                var response = botConfig.getCommands().get(chatIdAndUserMessage.get(chatId)).secondMessage(update);
                chatIdAndUserMessage.remove(chatId);
                sendAnswerMessage(response);

            } else {
                var response = new SendMessage();
                response.setChatId(chatId);
                response.setText("Command not required");
                sendAnswerMessage(response);
            }

        } else if (update.hasCallbackQuery()) {

            var chatId = update.getCallbackQuery().getMessage().getChatId();
            var buttonKey = update.getCallbackQuery().getData();

            if (botConfig.getButtonCommands().containsKey(buttonKey)) {

                if (buttonKey.equals("NEXT")) {
                    var response = new SendMessage();
                    response.setChatId(chatId);
                    response.setText(botConfig.getButtonCommands().get(buttonKey).actionButtonWithNextMessage(update));
                    sendAnswerMessage(response);

                } else {
                    EditMessageText responseInCurrentMessage = new EditMessageText();
                    responseInCurrentMessage.setChatId(chatId);
                    responseInCurrentMessage.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
                    responseInCurrentMessage.setText(botConfig.getButtonCommands().get(buttonKey).actionButtonInCurrentMessage(update));
                    sendAnswerMessage(responseInCurrentMessage);
                }
            }
        }
    }

    private void sendAnswerMessage(BotApiMethod message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
