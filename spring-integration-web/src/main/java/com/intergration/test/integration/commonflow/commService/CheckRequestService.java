package com.intergration.test.integration.commonflow.commService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CheckRequestService {
    public boolean checkReq(Message<?> message) {
        //消息头
        MessageHeaders messageHeaders = message.getHeaders();
        log.info("头部信息：{}", messageHeaders.toString());

        //消息内容
        Object obj = message.getPayload();
        log.info("内容信息：{}", (obj).toString());

        return true;
    }
}
