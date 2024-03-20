package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    final UserService userService;

    public boolean existsUserByChatId(Long chatId) {
       return userService.existsUserByChatId(chatId);
    }

    public void addUser(Long chatId, String userName) {
        userService.addUser(chatId, userName);
    }

    public void addBroadcasterInUserFollowList(Long userId, Broadcaster broadcaster) {
        userService.addBroadcasterInUserFollowList(userId, broadcaster);
    }

    public void addBroadcasterInUserBlackList(Long userId, Broadcaster broadcaster) {
        userService.addBroadcasterInUserBlackList(userId, broadcaster);
    }

}
