package com.alexlatkin.twitchclipsbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisConfig {
    @Value("${spring.data.redis.host}")
    private String redisHost;
    @Value("${spring.data.redis.port}")
    private int redisPort;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(redisHost, redisPort);

        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheConfiguration cacheConfiguration = defaultCacheConfiguration(Duration.ofMinutes(2)).disableCachingNullValues();

        return RedisCacheManager.builder(redisConnectionFactory()).cacheDefaults(cacheConfiguration).build();
    }

    private RedisCacheConfiguration defaultCacheConfiguration(Duration duration) {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(duration)
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}
