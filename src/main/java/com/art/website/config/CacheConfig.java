package com.art.website.config;

import com.art.website.cache.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Li shaoKang
 * @CreateDate: 2022/07/20 21:18
 * @Version: 1.0
 **/
@Configuration
public class CacheConfig {
    @Autowired
    private RedisTemplate redisTemplate;

    @Bean
    public SimpleCacheManager getSimCacheManager(){
        SimpleCacheManager cacheManager=new SimpleCacheManager();

        List<Cache> list=new ArrayList();
        RedisCache redisCache=new RedisCache();
        redisCache.setRedisTemplate(redisTemplate);
        redisCache.setName("redisCache");
        list.add(redisCache);
        cacheManager.setCaches(list);
        return cacheManager;
    }
}
