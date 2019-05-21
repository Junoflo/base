package com.liuyibo.me.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author liuyibo
 * @Date 2019-05-21
 * @Desc
 */
@Configuration
public class JedisConfig {

    @Bean("baseJedisPool")
    public JedisPool jedisPool(RedisProperties properties) throws URISyntaxException {
        final GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(30000);
        poolConfig.setTestOnBorrow(true);
        final StringBuilder uri = new StringBuilder("util://");
        if (StringUtils.isNotBlank(properties.getPassword())) {
            uri.append(":").append(properties.getPassword()).append("@");
        }
        uri.append(properties.getHost()).append(":");
        uri.append(properties.getPort()).append("/");
        uri.append(properties.getDatabase());
        return new JedisPool(poolConfig, new URI(uri.toString()));
    }
}
