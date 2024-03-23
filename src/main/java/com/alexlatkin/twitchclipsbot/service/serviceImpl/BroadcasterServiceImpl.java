package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.model.repository.BroadcasterRepository;
import com.alexlatkin.twitchclipsbot.service.BroadcasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class BroadcasterServiceImpl implements BroadcasterService {
    private final BroadcasterRepository broadcasterRepository;
    @Override
    public boolean existsBroadcasterByBroadcasterName(String broadcasterName) {
        return broadcasterRepository.existsBroadcasterByBroadcasterName(broadcasterName);
    }

    @Override
    public Broadcaster getBroadcasterByBroadcasterName(String broadcasterName) {
        return broadcasterRepository.findBroadcasterByBroadcasterName(broadcasterName);
    }

    @Override
    public void addBroadcaster(Broadcaster broadcaster) {
        broadcasterRepository.save(broadcaster);
    }

}
