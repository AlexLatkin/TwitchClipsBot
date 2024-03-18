package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.entity.User;
import com.alexlatkin.twitchclipsbot.model.repository.UserRepository;
import com.alexlatkin.twitchclipsbot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public boolean existsUserByChatId(Long chatId) {
        return userRepository.existsUserByChatId(chatId);
    }

    @Override
    public void addBroadcasterInUserFollowList(Long userId, Integer broadcasterId) {
        userRepository.addBroadcasterInUserFollowList(userId, broadcasterId);
    }

    @Override
    public void addBroadcasterInUserBlackList(Long userId, Integer broadcasterId) {
        userRepository.addBroadcasterInUserBlackList(userId, broadcasterId);
    }

    @Override
    public void addUser(Long chatId, String userName) {
        User user = new User();
        user.setChatId(chatId);
        user.setUserName(userName);
        userRepository.save(user);
    }
}
