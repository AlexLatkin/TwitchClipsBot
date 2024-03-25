package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotButtonCommands extends BotCommands{
    String clickFollowButton(Update update);
    String clickBlockButton(Update update);
    String clickNextButton(Update update);
}
