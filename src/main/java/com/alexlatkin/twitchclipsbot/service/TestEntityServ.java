package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.entity.TestEntity;
import com.alexlatkin.twitchclipsbot.model.repository.TestRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class TestEntityServ {
    TestRepo testRepo;
    @Cacheable("test")
    public TestEntity getTestByName(String name) {
        return testRepo.findTestEntitiesByName(name);
    }
}
