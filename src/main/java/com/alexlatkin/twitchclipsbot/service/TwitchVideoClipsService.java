package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.RootTwitchUser;
import com.alexlatkin.twitchclipsbot.dto.TwitchUser;
import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

@PropertySource("classpath:application.properties")
@Service
public class TwitchVideoClipsService implements VideoClipsService {

    @Value("${twitchVideoClipsService.URL}")
    private URL url;
    @Value("${twitchVideoClipsService.firstHeaderKey}")
    private String firstHeaderKey;
    @Value("${twitchVideoClipsService.secondHeaderKey}")
    private String secondHeaderKey;
    @Value("#{${twitchVideoClipsService.headers}}")
    private Headers headers;

    @Override
    public VideoClipsDto getVideoClipsByBroadcastersId(List<Long> BroadcasterId) {
        return null;
    }

    @Override
    public VideoClipsDto getVideoClipsByGameId(Long gameId) {
        return null;
    }

    @Override
    public Long getGames(String gameName) {
        return null;
    }

    @Override
    public int getBroadcasterId(String broadcasterName) throws IOException, InterruptedException, URISyntaxException {

        var uri = new URI("https://api.twitch.tv/helix/users?login=" + broadcasterName);

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header("Authorization", "Bearer u78uni2ggpp350gqsdk9s0n6jd3gzg")
                .header("Client-Id", "kuwtiwhhj9q8stp6yvjo4cxp866xf4")
                .timeout(Duration.ofSeconds(10))
                .build();

         var response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));


        ObjectMapper mapper = new ObjectMapper();

        RootTwitchUser rootTwitchUser = new RootTwitchUser();

        rootTwitchUser = mapper.readValue(response.body(), RootTwitchUser.class);

        return rootTwitchUser.getData().get(0).getId();
    }
}
