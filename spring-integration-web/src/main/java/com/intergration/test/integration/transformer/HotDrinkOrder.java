package com.intergration.test.integration.transformer;

import com.intergration.test.model.request.base.Order;
import lombok.Data;


@Data
public class HotDrinkOrder extends Order {
    private String name;
    public HotDrinkOrder(String name){
        this.name = name;
    }
}
