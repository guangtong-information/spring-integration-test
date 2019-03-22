package com.intergration.test.integration.commonflow.commService;


import com.intergration.test.constant.ResponseCodeConstant;
import com.intergration.test.integration.transflow.wrapper.PayRequestWrapper;
import com.intergration.test.model.response.TransRes;
import com.intergration.test.model.response.base.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConvertResultService {


    public ExternalResponse<TransRes> handle(PayRequestWrapper payRequestWrapper) {
        ExternalResponse<TransRes> res = new ExternalResponse<TransRes>();
        if (payRequestWrapper.isComplete()) {
            TransRes transRes = new TransRes();
            transRes.setDrinkName(payRequestWrapper.getDrinkName());
            transRes.setIsComplete(payRequestWrapper.isComplete());
            res.setResult(transRes);
            res.setCode(ResponseCodeConstant.SUCCESS.getResponseCode());
            res.setMsg("成功制作");
        } else {
            TransRes transRes = new TransRes();
            transRes.setDrinkName(payRequestWrapper.getDrinkName());
            transRes.setIsComplete(payRequestWrapper.isComplete());
            res.setResult(transRes);
            res.setCode(ResponseCodeConstant.FAIL.getResponseCode());
            res.setMsg("失败制作");
        }
        return res;
    }


}
