package com.intergration.test.integration.transflow.service;

import com.intergration.test.integration.transformer.HotDrinkOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class HotDrink {
    public HotDrinkOrder transform(HotDrinkOrder hotDrinkOrder) {
        try {
            for (int i = 0; i < 3; i++) {
                log.info("正在制作热饮【{}】...", hotDrinkOrder.getName());
                //Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hotDrinkOrder;
    }
}
