package com.intergration.test.integration.transflow.service;

import com.intergration.test.integration.transformer.CoolDrinkOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class CoolDrink {


    public CoolDrinkOrder transform(CoolDrinkOrder coolDrinkOrder) {
        try {
            for (int i = 0; i < 3; i++) {
                log.info("正在制作冷饮【{}】...", coolDrinkOrder.getName());
                //Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return coolDrinkOrder;
    }
}
