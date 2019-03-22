package com.intergration.test.service;


import com.intergration.test.model.request.TransRequest;
import com.intergration.test.model.response.TransRes;
import com.intergration.test.model.response.base.ExternalResponse;

/**
 * 账户收支明细
 * Created by winlone
 * Date: 2016-8-8.
 */
public interface TransService {

    /**
     * 收支明细账单信息查询
     * @param request
     * @return
     */
    ExternalResponse<TransRes> trans(TransRequest request);

}
