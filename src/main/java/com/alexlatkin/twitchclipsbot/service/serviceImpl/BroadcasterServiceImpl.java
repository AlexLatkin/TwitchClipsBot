package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.model.repository.BroadcasterRepository;
import com.alexlatkin.twitchclipsbot.service.BroadcasterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BroadcasterServiceImpl implements BroadcasterService {
    BroadcasterRepository broadcasterRepository;
    @Override
    public boolean existsBroadcasterByBroadcasterName(String broadcasterName) {
        return broadcasterRepository.existsBroadcasterByBroadcasterName(broadcasterName);
    }

    @Override
    public Broadcaster getBroadcasterByBroadcasterName(String broadcasterName) {
        return broadcasterRepository.findBroadcasterByBroadcasterName(broadcasterName);
    }

    @Override
    public void addBroadcaster(Integer broadcasterId, String broadcasterName) {
        Broadcaster broadcaster = new Broadcaster();
        broadcaster.setBroadcasterId(broadcasterId);
        broadcaster.setBroadcasterName(broadcasterName);
        broadcasterRepository.save(broadcaster);
    }

    @Override
    public List<Broadcaster> getBroadcastersFromUserFollowListByUserId(Long userId) {
        return broadcasterRepository.followListByUserId(userId);
    }

    @Override
    public List<Broadcaster> getBroadcastersFromUserBlackListByUserId(Long userId) {
        return broadcasterRepository.blackListByUserId(userId);
    }
}
