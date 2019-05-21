package com.liuyibo.me.service;

import com.liuyibo.me.component.RedisClient;
import com.liuyibo.me.component.RedisConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author liuyibo
 * @Date 2019-05-21
 * @Desc
 */
@Service
public class WarnService {

    @Value("${warnInterval:3000}")
    private Long warnInterval;

    @Value("${warnChatroom:1111}")
    private String warnChatroom;

    @Resource
    private RedisClient redisClient;

    @Resource
    private WechatClientService wechatClientService;

    /**
     * 发送到开发报警群
     */
    public void alarm(String msg) {
        String lastWarnTimeStr = redisClient.get(RedisConstant.genKey4LastWarnTime());
        long lastWarnTime = StringUtils.isEmpty(lastWarnTimeStr) ? 0L : Long.parseLong(lastWarnTimeStr);
        if ((System.currentTimeMillis() - lastWarnTime) < warnInterval) {
            return;
        }
        redisClient.set(RedisConstant.genKey4LastWarnTime(), String.valueOf(System.currentTimeMillis()));
        wechatClientService.sendText2Chatroom(msg, warnChatroom);
    }

}
