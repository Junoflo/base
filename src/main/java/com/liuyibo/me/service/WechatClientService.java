package com.liuyibo.me.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baijia.storm.lib.constant.wechat.enumeration.EMessage;
import com.baijia.storm.sun.api.common.constant.AddressType;
import com.baijia.storm.sun.api.common.proto.SunApiResponse;
import com.baijia.storm.sun.api.common.proto.SunChat;
import com.baijia.storm.sun.api.open.OpenApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @Author liuyibo
 * @Date 2019-05-21
 * @Desc
 */
@Slf4j
@Component
public class WechatClientService {

    @Reference(version = "1.0.0")
    private OpenApi openApi;

    private SunChat buildSunChat(Integer weChatMsgType, String content, List<String> addressList, Integer addressType) {
        return new SunChat(weChatMsgType, content, addressList, addressType);
    }

    public void sendText2Chatroom(String content, String chatroom) {
        SunChat sunChat = this.buildSunChat(EMessage.TYPE__TEXT, content, Collections.singletonList(chatroom),
                AddressType.CHATROOM);
        SunApiResponse response = openApi.send(sunChat);
        if (response.getCode() != 0) {
            log.error("error occurred while sendToChatroom, content:{} chatroom:{}, code:{}", content, chatroom,
                    response.getCode());
        }
    }

}
