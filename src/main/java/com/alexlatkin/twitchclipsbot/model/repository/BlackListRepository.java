package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {
}
