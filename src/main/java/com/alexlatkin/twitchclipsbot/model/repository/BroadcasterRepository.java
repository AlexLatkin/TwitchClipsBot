package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BroadcasterRepository extends JpaRepository<Broadcaster, Integer> {
    Broadcaster findBroadcasterByBroadcasterName(String broadcasterName);
}
