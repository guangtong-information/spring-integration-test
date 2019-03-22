package com.intergration.test.integration.commonflow.router;

import com.intergration.test.integration.transformer.CoolDrinkOrder;
import com.intergration.test.integration.transformer.HotDrinkOrder;
import com.intergration.test.model.request.base.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SendOrderInputRouter {

    public String route(Order order) {
        if (order instanceof CoolDrinkOrder) {
            log.info("把饮料分{}给制作冷饮的人制作", ((CoolDrinkOrder) order).getName());
            return "coolDrinkOrderChannel";
        } else {
            log.info("把饮料分{}给制作热饮的人制作", ((HotDrinkOrder) order).getName());
            return "hotDrinkOrderChannel";
        }
    }
}
