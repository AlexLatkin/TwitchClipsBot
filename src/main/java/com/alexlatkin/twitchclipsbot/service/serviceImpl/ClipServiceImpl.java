package com.alexlatkin.twitchclipsbot.service.serviceImpl;

import com.alexlatkin.twitchclipsbot.model.dto.TwitchClipsDto;
import com.alexlatkin.twitchclipsbot.model.entity.Broadcaster;
import com.alexlatkin.twitchclipsbot.model.entity.Game;
import com.alexlatkin.twitchclipsbot.service.BroadcasterService;
import com.alexlatkin.twitchclipsbot.service.ClipService;
import com.alexlatkin.twitchclipsbot.service.GameService;
import com.alexlatkin.twitchclipsbot.twitchAPI.TwitchService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@Service
public class ClipServiceImpl implements ClipService {
    private final TwitchService twitchService;
    private final GameService gameService;
    private final BroadcasterService broadcasterService;

    @Override
    @Cacheable("gameClips")
    public TwitchClipsDto getClipsByGameName(String gameName) throws URISyntaxException, IOException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var gameId = 0;

        if (gameService.existsGameByGameName(gameName)) {
            gameId = gameService.getGameByGameName(gameName).getGameId();
        } else {
            gameId = twitchService.getGame(gameName).getId();
            Game game = new Game();
            game.setGameId(gameId);
            game.setGameName(gameName);
            gameService.addGame(game);
        }

        return twitchService.getClipsByGameId(gameId, date);
    }

    @Override
    public List<CompletableFuture<TwitchClipsDto>> getClipsByUserFollowList(List<Broadcaster> userFollowList) throws URISyntaxException, IOException, InterruptedException, ExecutionException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        List<CompletableFuture<TwitchClipsDto>> allClips = new ArrayList<>();

        var broadcastersId = userFollowList.stream().map(Broadcaster::getBroadcasterId).toList();

        broadcastersId.forEach(bcId -> {
            try {
                allClips.add(twitchService.getClipsByBroadcastersId(bcId, date));
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture.allOf(allClips.toArray(new CompletableFuture[0])).get();

        return allClips;
    }

    @Override
    public TwitchClipsDto getClipsByBroadcasterName(String broadcasterName) throws URISyntaxException, IOException, InterruptedException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = localDate.format(dateTimeFormatter);

        var broadcasterId = 0;

        if (broadcasterService.existsBroadcasterByBroadcasterName(broadcasterName)) {
            broadcasterId = broadcasterService.getBroadcasterByBroadcasterName(broadcasterName).getBroadcasterId();
        } else {
            var broadcasterTwitch = twitchService.getBroadcaster(broadcasterName);
            var bc = new Broadcaster();
            bc.setBroadcasterId(broadcasterTwitch.getId());
            bc.setBroadcasterName(broadcasterName);
            broadcasterService.addBroadcaster(bc);
            broadcasterId = broadcasterTwitch.getId();
        }

        return twitchService.getClipsByBroadcasterId(broadcasterId, date);
    }

    @Override
    public CompletableFuture<TwitchClipsDto> test(int bcId, String date) throws IOException, URISyntaxException, ExecutionException, InterruptedException {
        return twitchService.getClipsByBroadcastersId(bcId, date);
    }
}
