package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.entity.TestEntity;
import com.alexlatkin.twitchclipsbot.model.repository.TestRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class TestEntityServ {
    TestRepo testRepo;

//    @Cacheable(value = "TestEntityServ::getTestById", key = "#id")
    public TestEntity getTestByName(String name) {
        return testRepo.findTestEntitiesByName(name);
    }
}
