package com.demo.my.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;

@PropertySource("classpath:redis.properties")
public class RedisConfiguration {

    @Value("${redis.hostname}")
    private String hostname;

    @Value("${redis.port}")
    private String port;

    @Bean(name = "redisStandaloneConfiguration")
    public RedisStandaloneConfiguration getRedisStandaloneConfiguration() {
        return new RedisStandaloneConfiguration(hostname, Integer.parseInt(port));
    }
}
