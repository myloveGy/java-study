package com.demo.my.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

public class RedisTemplateConfiguration {

    @Resource(name = "keySerializer")
    private RedisSerializer redisKeySerializer;

    @Resource(name = "valueSerializer")
    private RedisSerializer redisValueSerializer;

    @Resource(name = "redisConnectionFactory")
    private JedisConnectionFactory redisConnectionFactory;

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(redisKeySerializer);
        redisTemplate.setValueSerializer(redisValueSerializer);
        return redisTemplate;
    }
}
