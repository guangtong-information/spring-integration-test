package com.intergration.test.integration.transflow.service;

import com.intergration.test.integration.transflow.wrapper.PayRequestWrapper;
import com.intergration.test.model.request.base.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class WaiterSend extends AbstractTransformer {
    @Override
    public PayRequestWrapper doTransform(Message<?> message) {
        PayRequestWrapper payRequestWrapper = (PayRequestWrapper) message.getPayload();
        List<Order> list = payRequestWrapper.getOrders();
        log.info("服务员把饮料发给客户饮用,饮料列表:{}", list.toString());
        return payRequestWrapper;
    }
}
