package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.net.URISyntaxException;

public interface BotCommands {
    BotApiMethod firstMessage(Update update);
    BotApiMethod secondMessage(Update update) throws URISyntaxException, IOException, InterruptedException;
}
