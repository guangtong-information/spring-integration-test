package com.intergration.test.integration.transflow.wrapper;


import com.intergration.test.model.request.base.Order;
import com.intergration.test.model.request.base.PayRequest;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Data
@ToString
@Slf4j
public class PayRequestWrapper extends BaseRequestWrapper {

    private PayRequest payRequest;

    private  List<String> DrinkName;


    private List<Order> orders;

}
