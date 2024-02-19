package com.alexlatkin.twitchclipsbot.service;

import com.alexlatkin.twitchclipsbot.dto.RootTwitchGame;
import com.alexlatkin.twitchclipsbot.dto.RootTwitchUser;
import com.alexlatkin.twitchclipsbot.dto.TwitchGameDto;
import com.alexlatkin.twitchclipsbot.dto.VideoClipsDto;
import com.alexlatkin.twitchclipsbot.model.VideoClip;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
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
    public List<VideoClip> getVideoClipsByGameName(String gameName) throws IOException, InterruptedException, URISyntaxException {
        TwitchVideoClipsService twitchVideoClipsService = new TwitchVideoClipsService();

        var gameId = twitchVideoClipsService.getGameId(gameName);

        System.out.println(gameId);

        var uri = new URI("https://api.twitch.tv/helix/clips?game_id=" + gameId);

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

        VideoClipsDto videoClipsDto;

        videoClipsDto = mapper.readValue(response.body(), VideoClipsDto.class);

        return videoClipsDto.getData();
    }

    @Override
    public int getGameId(String gameName) throws URISyntaxException, IOException, InterruptedException {
        var uri = new URI("https://api.twitch.tv/helix/games?name=" + gameName.replace(" ", "%20"));

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

        RootTwitchGame rootTwitchGame = new RootTwitchGame();

        rootTwitchGame = mapper.readValue(response.body(), RootTwitchGame.class);

        return rootTwitchGame.getData().get(0).getId();
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
