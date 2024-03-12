package com.alexlatkin.twitchclipsbot.model.repository;

import com.alexlatkin.twitchclipsbot.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
