package com.alexlatkin.twitchclipsbot.service;

public interface UserService {
    void addUser(Long chatId, String userName);
    void addBroadcasterInUserFollowList(Long userId, Integer broadcasterId);
    void addBroadcasterInUserBlackList(Long userId, Integer broadcasterId);
    boolean existsUserByChatId(Long chatId);
}
