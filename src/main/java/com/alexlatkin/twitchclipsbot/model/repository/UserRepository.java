package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByChatId(Long chatId);
}
