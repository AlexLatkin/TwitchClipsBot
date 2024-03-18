package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByChatId(Long chatId);
    @Modifying
    @Query(value = """ 
            INSERT INTO users_follow_list (users_id, broadcaster_id)
            VALUES (:userId, :broadcasterId)
            """, nativeQuery = true)
    void addBroadcasterInUserFollowList(@Param("userId") Long userId, @Param("broadcasterId") Integer broadcasterId);
    @Modifying
    @Query(value = """
            INSERT INTO users_black_list (users_id, broadcaster_id)
            VALUES (:userId, :broadcasterId)
            """, nativeQuery = true)
    void addBroadcasterInUserBlackList(@Param("userId") Long userId, @Param("broadcasterId") Integer broadcasterName);
}
