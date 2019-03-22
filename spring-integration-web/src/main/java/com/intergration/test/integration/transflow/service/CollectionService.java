package com.intergration.test.integration.transflow.service;

import com.intergration.test.integration.transflow.wrapper.PayRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CollectionService {
    public PayRequestWrapper collection(PayRequestWrapper payRequestWrapper){
        log.info("喝完收杯子了");
        return payRequestWrapper;
    }
}
