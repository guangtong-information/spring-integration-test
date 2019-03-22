package com.intergration.test.integration.transflow.service;

import com.intergration.test.integration.transflow.wrapper.PayRequestWrapper;
import com.intergration.test.model.request.base.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class AggregatorDrink {
    public PayRequestWrapper transform(List<Order> orders){
        log.info("厨师拿出做好的饮料[{}杯]",orders.toString());
        PayRequestWrapper payRequestWrapper = new PayRequestWrapper();
        payRequestWrapper.setOrders(orders);
        payRequestWrapper.setComplete(true);
        return payRequestWrapper;
    }
}
