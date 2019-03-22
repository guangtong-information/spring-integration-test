package com.intergration.test.service;


import com.intergration.test.model.request.TransRequest;
import com.intergration.test.model.response.TransRes;
import com.intergration.test.model.response.base.ExternalResponse;

/**
 * 交易饮料
 * Created by winlone
 * Date: 2016-8-8.
 */
public interface TransService {

    /**
     * 购买饮料流程
     * @param request
     * @return
     */
    ExternalResponse<TransRes> trans(TransRequest request);

}
