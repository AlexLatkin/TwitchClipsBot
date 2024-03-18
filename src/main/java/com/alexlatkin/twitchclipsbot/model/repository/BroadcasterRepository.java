package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BroadcasterRepository extends JpaRepository<Broadcaster, Integer> {
    Broadcaster findBroadcasterByBroadcasterName(String broadcasterName);
    boolean existsBroadcasterByBroadcasterName(String broadcasterName);

    @Query(value = """
            SELECT * FROM broadcaster b
            JOIN users_follow_list ufl ON ufl.broadcaster_id = b.broadcaster_id
            WHERE ufl.users_id = :userId
            """, nativeQuery = true)
    List<Broadcaster> followListByUserId(@Param("userId") Long userId);
    @Query(value = """
            SELECT * FROM broadcaster b
            JOIN users_black_list ubl ON ubl.broadcaster_id = b.broadcaster_id
            WHERE ubl.users_id = :userId
            """, nativeQuery = true)
    List<Broadcaster> blackListByUserId(@Param("userId") Long userId);
}
