package com.demo.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import javax.annotation.Resource;

public class RedisConnectionConfiguration {

    @Resource(name = "redisStandaloneConfiguration")
    private RedisStandaloneConfiguration redisStandaloneConfiguration;

    @Bean(name = "redisConnectionFactory")
    public JedisConnectionFactory getJedisConnectionFactory() {
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
}
