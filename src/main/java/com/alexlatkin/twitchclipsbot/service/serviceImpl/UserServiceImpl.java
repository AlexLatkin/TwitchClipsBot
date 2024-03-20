package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.model.entity.User;
import com.alexlatkin.twitchclipsbot.model.repository.UserRepository;
import com.alexlatkin.twitchclipsbot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Override
    public boolean existsUserByChatId(Long chatId) {
        return userRepository.existsUserByChatId(chatId);
    }

    @Override
    public void addUser(Long chatId, String userName) {
        User user = new User();
        user.setChatId(chatId);
        user.setUserName(userName);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void addBroadcasterInUserFollowList(Long chatId, Broadcaster broadcaster) {
        var user = userRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        user.getFollowList().add(broadcaster);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void addBroadcasterInUserBlackList(Long chatId, Broadcaster broadcaster) {
        var user = userRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        user.getBlackList().add(broadcaster);
        userRepository.save(user);
    }

    @Transactional
    @Override
    public List<Broadcaster> getUserFollowListByUserChatId(Long chatId) {
        var user = userRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return user.getFollowList();
    }

    @Transactional
    @Override
    public List<Broadcaster> getUserBlackListByUserChatId(Long chatId) {
        var user = userRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        return user.getBlackList();
    }

    @Override
    public void deleteBroadcasterFromUserFollowList(Long chatId, Broadcaster broadcaster) {
        var user = userRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        user.getFollowList().remove(broadcaster);
    }

    @Override
    public void deleteBroadcasterFromUserBlackList(Long chatId, Broadcaster broadcaster) {
        var user = userRepository.findById(chatId).orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        user.getBlackList().remove(broadcaster);
    }

    @Override
    public void clearUserFollowList(Long chatId) {

    }

    @Override
    public void clearUserBlackList(Long chatId) {

    }
}
