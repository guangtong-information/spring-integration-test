package com.intergration.test.service;

import com.intergration.test.gateway.RequestGateway;
import com.intergration.test.gateway.RequestGateway2;
import com.intergration.test.model.request.TransRequest;
import com.intergration.test.model.response.TransRes;
import com.intergration.test.model.response.base.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("transService")
@Slf4j
public class TransImpl implements TransService {

    @Autowired
    private RequestGateway requestGateway;

    @Autowired
    private RequestGateway2 requestGateway2;

    @Override
    public ExternalResponse<TransRes> trans(TransRequest request) {
        //方法一：创建消息对象
        Message<?> requestMessage = MessageBuilder.withPayload(request)
                .setHeader("keep", request.getKeep())
                .setHeader("appname", request.getAppName())
                .build();

        //方法二：创建消息对象
        Map headers = new HashMap();
        headers.put("keep", request.getKeep());
        headers.put("appname", request.getAppName());
        Message<?> requestMessage2 = new GenericMessage(request, headers);

        //发起工作流
        Message<?> rsp = requestGateway.sendRequest(requestMessage);

        return (ExternalResponse<TransRes>) rsp.getPayload();
    }

    @Override
    public ExternalResponse<TransRes> trans2(TransRequest request) {
        //方法一：创建消息对象
        Message<?> requestMessage = MessageBuilder.withPayload(request)
                .setHeader("keep", request.getKeep())
                .setHeader("appname", request.getAppName())
                .build();


        //发起工作流
        Message<?> rsp = requestGateway2.sendRequest(requestMessage);

        return (ExternalResponse<TransRes>) rsp.getPayload();
    }
}
