package com.alexlatkin.twitchclipsbot.controller;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.service.BroadcasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BroadcasterController {
    final BroadcasterService broadcasterService;

    public boolean existsBroadcasterByBroadcasterName(String broadcasterName) {
        return broadcasterService.existsBroadcasterByBroadcasterName(broadcasterName);
    }

    public Broadcaster getBroadcasterByBroadcasterName(String broadcasterName) {
        return broadcasterService.getBroadcasterByBroadcasterName(broadcasterName);
    }

    public void addBroadcaster(Broadcaster broadcaster) {
        broadcasterService.addBroadcaster(broadcaster);
    }

}
