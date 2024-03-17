package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.entity.User;

public interface UserService {
    User getUserByChatId(Long chatId);
    void addUser(Long chatId, String userName);
    boolean existsUserByChatId(Long chatId);
}
