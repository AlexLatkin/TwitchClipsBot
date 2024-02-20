package com.alexlatkin.twitchclipsbot.twitchAPI;


import com.alexlatkin.twitchclipsbot.dto.TwitchUser;

import java.io.IOException;
import java.net.URISyntaxException;

public interface UserService {
    TwitchUser getUser(String userName) throws URISyntaxException, IOException, InterruptedException;
}
