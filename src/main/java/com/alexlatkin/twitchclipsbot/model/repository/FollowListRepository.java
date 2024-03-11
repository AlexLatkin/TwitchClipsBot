package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.FollowList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowListRepository extends JpaRepository<FollowList, Integer> {
}
