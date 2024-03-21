package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;

import java.util.List;

public interface BroadcasterService {
    Broadcaster getBroadcasterByBroadcasterName(String broadcasterName);
    void addBroadcaster(Broadcaster broadcaster);
    boolean existsBroadcasterByBroadcasterName(String broadcasterName);
}
