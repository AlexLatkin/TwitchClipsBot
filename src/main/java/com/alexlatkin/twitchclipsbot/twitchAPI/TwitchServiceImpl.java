package com.alexlatkin.twitchclipsbot.twitchAPI;

import com.alexlatkin.twitchclipsbot.config.TwitchConfig;
import com.alexlatkin.twitchclipsbot.model.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
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
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
public class TwitchServiceImpl implements TwitchService {

    private final TwitchConfig twitchConfig;

    @Override
    public TwitchGameDto getGame(String gameName) throws URISyntaxException, IOException, InterruptedException {

        String path = "games?name=" + gameName.replace(" ", "%20");

        var uri = new URI(twitchConfig.getUrl() + path);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(twitchConfig.getFirstHeaderName(),"Bearer " + twitchConfig.getFirstHeaderValue())
                .header(twitchConfig.getSecondHeaderName(), twitchConfig.getSecondHeaderValue())
                .timeout(Duration.ofSeconds(20))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        ObjectMapper mapper = new ObjectMapper();

        RootTwitchGame rootTwitchGame = mapper.readValue(response.body(), RootTwitchGame.class);

        return rootTwitchGame.getData().get(0);
    }

    @Override
    public TwitchUser getBroadcaster(String broadcasterName) throws URISyntaxException, IOException, InterruptedException {

        String path = "users?login=" + broadcasterName;

        var uri = new URI(twitchConfig.getUrl() + path);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(twitchConfig.getFirstHeaderName(),"Bearer " + twitchConfig.getFirstHeaderValue())
                .header(twitchConfig.getSecondHeaderName(), twitchConfig.getSecondHeaderValue())
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

        String path ="clips?game_id=" + gameId + "&started_at=" + clipDate + "&first=100";

        var uri = new URI(twitchConfig.getUrl() + path);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(twitchConfig.getFirstHeaderName(),"Bearer " + twitchConfig.getFirstHeaderValue())
                .header(twitchConfig.getSecondHeaderName(), twitchConfig.getSecondHeaderValue())
                .timeout(Duration.ofSeconds(20))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        ObjectMapper mapper = new ObjectMapper();

        TwitchClipsDto twitchClipsDto = mapper.readValue(response.body(), TwitchClipsDto.class);

        return twitchClipsDto;
    }

    @Override
    @Async
    public CompletableFuture<TwitchClipsDto> getClipsByBroadcastersId(int broadcasterId, String date) throws ExecutionException, InterruptedException, IOException, URISyntaxException {
        String clipDate = date + "T00:00:00%2B03:00";

        String path ="clips?broadcaster_id=" + broadcasterId + "&started_at=" + clipDate;

        var uri = new URI(twitchConfig.getUrl() + path);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(twitchConfig.getFirstHeaderName(),"Bearer " + twitchConfig.getFirstHeaderValue())
                .header(twitchConfig.getSecondHeaderName(), twitchConfig.getSecondHeaderValue())
                .timeout(Duration.ofSeconds(20))
                .build();

        var response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8))
                .thenApply(HttpResponse::body);

        var twitchClipsDtoCompletableFuture = response.thenApply(data -> {
            var twitchClipsDto = new TwitchClipsDto();
            ObjectMapper mapper = new ObjectMapper();
            try {
                twitchClipsDto = mapper.readValue(data, TwitchClipsDto.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            return twitchClipsDto;
        });

        return twitchClipsDtoCompletableFuture;
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterId(int broadcasterId, String date) throws URISyntaxException, IOException, InterruptedException {
        String clipDate = date + "T00:00:00%2B03:00";

        String path ="clips?broadcaster_id=" + broadcasterId + "&started_at=" + clipDate;

        var uri = new URI(twitchConfig.getUrl() + path);

        var client = HttpClient.newHttpClient();

        var request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .header(twitchConfig.getFirstHeaderName(),"Bearer " + twitchConfig.getFirstHeaderValue())
                .header(twitchConfig.getSecondHeaderName(), twitchConfig.getSecondHeaderValue())
                .timeout(Duration.ofSeconds(20))
                .build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        ObjectMapper mapper = new ObjectMapper();

        TwitchClipsDto twitchClipsDto = mapper.readValue(response.body(), TwitchClipsDto.class);

        return twitchClipsDto;
    }
}
