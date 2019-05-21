package com.liuyibo.me.controller;

import com.liuyibo.me.component.RedisClient;
import com.liuyibo.me.component.Response;
import com.liuyibo.me.dal.dao.AccountDao;
import com.liuyibo.me.dal.po.AccountPo;
import com.liuyibo.me.service.WechatClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class Hello {

    @Resource
    private AccountDao accountDao;

    @Resource
    RedisClient redisClient;

    @Resource
    private WechatClientService wechatClientService;

    @Value("${test}")
    private String test;

    @RequestMapping("/hello")
    public Response hello() {
//        throw new BizException("ss");
        log.debug("this is debug");
        log.info("this is info");
        log.warn("this is warn");
        log.error("this is error");
//        wechatClientService.sendText2Chatroom("test", "6596099585@chatroom");
        return Response.successResponse(new AccountPo());
    }

}
