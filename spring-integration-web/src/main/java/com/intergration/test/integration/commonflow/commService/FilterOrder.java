package com.intergration.test.integration.commonflow.commService;

import com.intergration.test.integration.transformer.CommonDrinkOrder;
import com.intergration.test.model.request.base.PayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class FilterOrder {
    public boolean filter(PayRequest payRequest) throws Exception {
        List list = payRequest.getOrders();
        for (int i = 0; i < payRequest.getOrders().size(); i++) {
            if (payRequest.getOrders().get(i) instanceof CommonDrinkOrder) {
                log.info("这种普通饮料无法制作哦");
                list.remove(i);
            }
        }
        if (list.size() == 0) {
            throw new Exception("都不能做的饮料");
        } else {
            return true;
        }
    }
}
