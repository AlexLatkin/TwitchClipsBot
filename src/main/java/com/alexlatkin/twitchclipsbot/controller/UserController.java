package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    public boolean existsUserByChatId(Long chatId) {
       return userService.existsUserByChatId(chatId);
    }

    public void addUser(Long chatId, String userName) {
        userService.addUser(chatId, userName);
    }

    public void addBroadcasterInUserFollowList(Long userId, Integer broadcasterId) {
        userService.addBroadcasterInUserFollowList(userId, broadcasterId);
    }

    public void addBroadcasterInUserBlackList(Long userId, Integer broadcasterId) {
        userService.addBroadcasterInUserBlackList(userId, broadcasterId);
    }
}
