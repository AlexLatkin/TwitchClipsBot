package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.model.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.scheduling.annotation.Async;
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
public class TwitchServiceImpl implements TwitchService {
    private static final String URL = "https://api.twitch.tv/helix/";
    private String path;
    private static final String FIRST_HEADER_NAME = "Authorization";
    private static final String FIRST_HEADER_VALUE = "Bearer u78uni2ggpp350gqsdk9s0n6jd3gzg";
    private static final String SECOND_HEADER_NAME = "Client-Id";
    private static final String SECOND_HEADER_VALUE = "kuwtiwhhj9q8stp6yvjo4cxp866xf4";

    @Override
    public TwitchGameDto getGame(String gameName) throws URISyntaxException, IOException, InterruptedException {
        path = "games?name=" + gameName.replace(" ", "%20");

        var uri = new URI(URL + path);

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

        RootTwitchGame rootTwitchGame = mapper.readValue(response.body(), RootTwitchGame.class);

        return rootTwitchGame.getData().get(0);
    }

    @Override
    public TwitchUser getBroadcaster(String broadcasterName) throws URISyntaxException, IOException, InterruptedException {
        path = "users?login=" + broadcasterName;

        var uri = new URI(URL + path);

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

        RootTwitchUser rootTwitchUser = mapper.readValue(response.body(), RootTwitchUser.class);

        return rootTwitchUser.getData().get(0);
    }

    @Override
    public TwitchClipsDto getClipsByGameId(int gameId, String date) throws IOException, InterruptedException, URISyntaxException {
        String clipDate = date + "T00:00:00%2B03:00";

       path ="clips?game_id=" + gameId + "&started_at=" + clipDate + "&first=100";

        var uri = new URI(URL + path);

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

        TwitchClipsDto twitchClipsDto = mapper.readValue(response.body(), TwitchClipsDto.class);

        return twitchClipsDto;
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterName(int broadcasterId, String date) {



        return null;
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterNameTest(int broadcasterId, String date) throws URISyntaxException, IOException, InterruptedException {
        String clipDate = date + "T00:00:00%2B03:00";

        path ="clips?broadcaster_id=" + broadcasterId + "&started_at=" + clipDate;

        var uri = new URI(URL + path);

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

        TwitchClipsDto twitchClipsDto = mapper.readValue(response.body(), TwitchClipsDto.class);

        return twitchClipsDto;
    }
}
