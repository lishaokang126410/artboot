package com.art.website.config;

import io.lettuce.core.ReadFrom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Li shaoKang
 * @CreateDate: 2022/07/20 21:18
 * @Version: 1.0
 **/
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate getRedisTemplate(){
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);
        RedisClusterConfiguration configuration=new RedisClusterConfiguration();
        configuration.setMaxRedirects(6);
        List<RedisNode> nodesList=new ArrayList();
/*        nodesList.add(new RedisNode("192.168.137.200",7001));
        nodesList.add(new RedisNode("192.168.137.200",7002));
        nodesList.add(new RedisNode("192.168.137.200",7003));
        nodesList.add(new RedisNode("192.168.137.200",7004));
        nodesList.add(new RedisNode("192.168.137.200",7005));
        nodesList.add(new RedisNode("192.168.137.200",7006));*/
        configuration.setClusterNodes(nodesList);
        JedisConnectionFactory factory=new JedisConnectionFactory(configuration);
        factory.setPoolConfig(config);
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(factory);
        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
       JdkSerializationRedisSerializer jdkSerializationRedisSerializer= new JdkSerializationRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(jdkSerializationRedisSerializer);
        return redisTemplate;
    }
}
