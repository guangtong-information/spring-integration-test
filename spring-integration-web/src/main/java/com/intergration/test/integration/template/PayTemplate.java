package com.intergration.test.integration.template;


import com.intergration.test.integration.transflow.wrapper.PayRequestWrapper;
import com.intergration.test.integration.transflow.wrapper.PayResponseWrapper;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public abstract class PayTemplate {

    public PayResponseWrapper pay(PayRequestWrapper wrapper) {
        //交易前判断
        prePay(wrapper);
        //执行交易
        PayResponseWrapper peResponseWrapper = concretePay(wrapper);
        //设置返回值
        peResponseWrapper.setPayRequestWrapper(wrapper);

        return peResponseWrapper;
    }

    /**
     * 交易调用
     * @param wrapper
     * @return
     */
    public abstract PayResponseWrapper concretePay(PayRequestWrapper wrapper);

    /**
     * 交易前验证
     * @param wrapper
     */
    public abstract void prePay(PayRequestWrapper wrapper);


}