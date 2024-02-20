package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.config.TwitchApiConfig;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@Service
public class UserServiceImpl implements UserService {
    TwitchApiConfig twitchApiConfig;

    @Autowired
    public UserServiceImpl(TwitchApiConfig twitchApiConfig) {
        this.twitchApiConfig = twitchApiConfig;
    }

    @Override
    public TwitchUser getUser(String userName) throws URISyntaxException, IOException, InterruptedException {
        var uri = new URI(twitchApiConfig.getUrl() +"users?login=" + userName);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(twitchApiConfig.getFirstHeaderName(), twitchApiConfig.getFirstHeaderValue())
                .header(twitchApiConfig.getSecondHeaderName(), twitchApiConfig.getSecondHeaderValue())
                .timeout(Duration.ofSeconds(20))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        ObjectMapper mapper = new ObjectMapper();

        TwitchUser twitchUser;

        twitchUser = mapper.readValue(response.body(), TwitchUser.class);


        return twitchUser;
    }
}
