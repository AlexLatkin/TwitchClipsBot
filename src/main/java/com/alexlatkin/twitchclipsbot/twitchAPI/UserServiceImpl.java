package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.config.TwitchApiConfig;
import com.alexlatkin.twitchclipsbot.dto.RootTwitchUser;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    private static final String URL = "https://api.twitch.tv/helix/users?login=";
    private static final String FIRST_HEADER_NAME = "Authorization";
    private static final String FIRST_HEADER_VALUE = "Bearer u78uni2ggpp350gqsdk9s0n6jd3gzg";
    private static final String SECOND_HEADER_NAME = "Client-Id";
    private static final String SECOND_HEADER_VALUE = "kuwtiwhhj9q8stp6yvjo4cxp866xf4";

    @Override
    public TwitchUser getUser(String userName) throws URISyntaxException, IOException, InterruptedException {
        var uri = new URI(URL + userName);

        System.out.println(uri);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(FIRST_HEADER_NAME, FIRST_HEADER_VALUE)
                .header(SECOND_HEADER_NAME, SECOND_HEADER_VALUE)
                .timeout(Duration.ofSeconds(20))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        ObjectMapper mapper = new ObjectMapper();

        RootTwitchUser rootTwitchUser;

        rootTwitchUser = mapper.readValue(response.body(), RootTwitchUser.class);


        return rootTwitchUser.getData().get(0);
    }
}
