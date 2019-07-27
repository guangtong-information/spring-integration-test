package com.intergration.test.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.Message;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
public interface RequestGateway2 {
    @Gateway(requestChannel = "requestInputChannel2")
    public Message<?> sendRequest(Message<?> request);


}
