package com.intergration.test.integration.transformer;

import com.intergration.test.model.request.base.Order;
import lombok.Data;


@Data
public class CoolDrinkOrder extends Order {
    private String name;
    public CoolDrinkOrder(String name){
        this.name = name;
    }
}
