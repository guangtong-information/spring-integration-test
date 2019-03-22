package com.intergration.test.integration.transflow.service;

import com.intergration.test.model.request.base.Order;
import com.intergration.test.model.request.base.PayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class OrderSpliter {

    public List<Order> splitMsg(PayRequest payRequest){
        log.info("开始把订单切分成【{}】杯",payRequest.getOrders().size());
        List<Order> list = payRequest.getOrders();
        return list;
    }


}
