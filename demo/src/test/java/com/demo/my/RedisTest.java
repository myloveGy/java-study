package com.demo.my;

import com.demo.my.config.SpringConfiguration;
import com.demo.my.redis.Role;
import com.demo.my.util.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class RedisTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Role> redisTemplate;

    @Test
    public void redisClient() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username", "jinxing.liu");
        System.out.println(jedis.get("username"));
    }

    @Test
    public void redis() {
        Role role = new Role();
        role.setRoleName("管理员");
        role.setId(1L);
        role.setCreatedAt(DateTime.format());
        redisTemplate.opsForValue().set("name:1", role);

        Role role2 = new Role();
        role2.setId(2L);
        role2.setRoleName("超级管理员");
        role2.setCreatedAt(DateTime.format());
        redisTemplate.opsForValue().set("name:2", role2);
    }

    @Test
    public void get() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Role.class));
        Role role = redisTemplate.opsForValue().get("name:2");
        System.out.println(role);
        if (role != null) {
            System.out.println(role.getRoleName());
            System.out.println(role.getCreatedAt());
        }
    }
}
