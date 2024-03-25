package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;

import java.util.List;

public interface UserService {
    boolean existsUserByChatId(Long chatId);
    void addUser(Long chatId, String userName);
    void addBroadcasterInUserFollowList(Long chatId, Broadcaster broadcaster);
    void addBroadcasterInUserBlackList(Long chatId, Broadcaster broadcaster);
    List<Broadcaster> getUserFollowListByUserChatId(Long chatId);
    List<Broadcaster> getUserBlackListByUserChatId(Long chatId);
    void deleteBroadcasterFromUserFollowList(Long chatId, Broadcaster broadcaster);
    void deleteBroadcasterFromUserBlackList(Long chatId, Broadcaster broadcaster);
    void clearUserFollowList(Long chatId);
    void clearUserBlackList(Long chatId);
}
