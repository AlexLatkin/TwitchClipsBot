package com.alexlatkin.twitchclipsbot.telegramBotCommands.textCommands;

import com.alexlatkin.twitchclipsbot.config.TwitchConfig;
import com.alexlatkin.twitchclipsbot.controller.BroadcasterController;
import com.alexlatkin.twitchclipsbot.controller.ClipsController;
import com.alexlatkin.twitchclipsbot.controller.UserController;
import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchServiceImpl;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@AllArgsConstructor
public class HelpCommand implements BotCommands {
    UserController userController;
    BroadcasterController broadcasterController;
    ClipsController clipsController;
    @Override
    public BotApiMethod firstMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Описание команд";

        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        CompletableFuture<TwitchClipsDto> a = null;
        try {
            a = clipsController.test(71558231, date);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        try {
            System.out.println(a.get().getData().get(0));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        return new SendMessage(chatId, answerText);
    }
    @Override
    public BotApiMethod secondMessage(Update update) {
        var chatId = update.getMessage().getChatId().toString();
        var answerText = "Команда не поддерживается";





//        Broadcaster broadcasterTest = new Broadcaster();
//        broadcasterTest.setBroadcasterId(6);
//        broadcasterTest.setBroadcasterName("Qwqe");
//        broadcasterController.addBroadcaster(broadcasterTest);


        Jedis jedis = new Jedis();

        String cacheResponse = jedis.get("gameClips::Dota 2");

        System.out.println(cacheResponse);


//
//        broadcasterController.addBroadcaster(broadcasterTest.getBroadcasterId(), broadcasterTest.getBroadcasterName());
//
//        userController.addBroadcasterInUserFollowList(update.getMessage().getChatId(), broadcasterTest.getBroadcasterId());

        return new SendMessage(chatId, answerText);
    }
}
