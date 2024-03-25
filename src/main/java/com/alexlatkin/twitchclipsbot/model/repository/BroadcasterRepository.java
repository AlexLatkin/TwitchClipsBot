package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.model.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BroadcasterRepository extends JpaRepository<Broadcaster, Integer> {
    Broadcaster findBroadcasterByBroadcasterName(String broadcasterName);
    boolean existsBroadcasterByBroadcasterName(String broadcasterName);
}
