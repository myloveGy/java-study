package com.demo.my;

import com.demo.my.config.SpringConfiguration;
import com.demo.my.redis.Role;
import com.demo.my.util.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class RedisTest {

    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void redisClient() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("username", "jinxing.liu");
        System.out.println(jedis.get("username"));
    }

    @Test
    public void redis() {
        System.out.println(redisTemplate);
        Role role = new Role();
        role.setRoleName("管理员");
        role.setId(1L);
        role.setCreatedAt(DateTime.format());
        redisTemplate.boundValueOps("name").set(role);

        Role role2 = (Role) redisTemplate.opsForValue().get("name");
        if (role2 != null) {
            Assert.assertEquals("管理员", role2.getRoleName());
            role2.setId(2L);
            role2.setRoleName("jinxing.liu");
            role2.setCreatedAt(DateTime.format());
            redisTemplate.opsForValue().set("name:2", role2);
        }
    }
}
