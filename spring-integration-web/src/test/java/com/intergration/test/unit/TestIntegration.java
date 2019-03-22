package com.intergration.test.unit;

import com.google.common.collect.Lists;
import com.intergration.test.constant.ResponseCodeConstant;
import com.intergration.test.integration.transformer.CommonDrinkOrder;
import com.intergration.test.integration.transformer.CoolDrinkOrder;
import com.intergration.test.integration.transformer.HotDrinkOrder;
import com.intergration.test.model.request.TransRequest;
import com.intergration.test.model.request.base.Order;
import com.intergration.test.model.response.TransRes;
import com.intergration.test.model.response.base.ExternalResponse;
import com.intergration.test.service.TransService;
import com.intergration.test.unit.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestIntegration extends BaseTest {

    @Autowired
    TransService transService;

    @Test
    public void testDrink() {
        TransRequest request = new TransRequest();
        request.setKeep("test111");
        request.setAppName("test");
        request.setIntegrationChannel("a");

        //饮料列表
        List<Order> list = Lists.newArrayList();
        CommonDrinkOrder commonDrinkOrder = new CommonDrinkOrder();
        CoolDrinkOrder coolDrinkOrder = new CoolDrinkOrder("草莓");
        CoolDrinkOrder coolDrinkOrder2 = new CoolDrinkOrder("柠檬");
        HotDrinkOrder hotDrinkOrder = new HotDrinkOrder("奶茶");
        HotDrinkOrder hotDrinkOrder2 = new HotDrinkOrder("咖啡");
        list.add(commonDrinkOrder);
        list.add(coolDrinkOrder2);
        list.add(coolDrinkOrder);
        list.add(hotDrinkOrder);
        list.add(hotDrinkOrder2);
        request.setOrders(list);


        ExternalResponse<TransRes> response = transService.trans(request);
        response = transService.trans(request);
        System.out.println(response.toString());
        Assert.assertEquals(response.getErrorCode(), ResponseCodeConstant.SUCCESS.getResponseCode());
    }

    /**
     * 通用请求参数
     */
    @Override
    public void initRequestInner() {

    }

    /**
     * mock测试
     */
    @Override
    public void fullMockInner() {

    }
}
