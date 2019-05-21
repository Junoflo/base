package com.liuyibo.me.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * @Author liuyibo
 * @Date 2019-05-20
 * @Desc
 */
@Slf4j
@Component
public class RedisClient {

    @Resource
    private JedisPool baseJedisPool;

    private <T> T doRedisAction(Function<Jedis, T> func) {
        try {
            Jedis jedis = null;
            try {
                jedis = baseJedisPool.getResource();
                return func.apply(jedis);
            } finally {
                if (jedis != null) {
                    try {
                        jedis.close();
                    } catch (Exception e) {
                        log.warn("jedis close failed, ", e);
                    }
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("Error while do util action: " + e.getMessage(), e);
        }
    }

    /**
     * @see Jedis#exists(String)
     */
    public Boolean exists(String key) {
        return doRedisAction(jedis -> jedis.exists(key));
    }

    public String get(String key) {
        return doRedisAction(jedis -> jedis.get(key));
    }

    public String set(String key, String value) {
        return doRedisAction(jedis -> jedis.set(key, value));
    }
}
