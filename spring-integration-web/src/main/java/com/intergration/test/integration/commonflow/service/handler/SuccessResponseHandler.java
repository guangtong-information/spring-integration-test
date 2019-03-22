package com.intergration.test.integration.commonflow.service.handler;


import com.intergration.test.integration.transflow.wrapper.PayResponseWrapper;
import com.intergration.test.model.response.base.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class SuccessResponseHandler {
//    @Resource
//    private PeResultConverter peResultConverter;

    /**
     * 将结果进行转换
     *
     * @param obj
     * @return
     */
    private Object convertResult(Object obj, String initID) {
//        try {
//            if (obj == null) {
//                return null;
//            }
//            if (obj instanceof PeCompositePaymentResponse) {
//                return peResultConverter.covertPeCompositePaymentResponse((PeCompositePaymentResponse) obj);
//            } else if (obj instanceof PeNetBankTransRes) {
//                return peResultConverter.convertPeNetBankTransRes((PeNetBankTransRes) obj, initID);
//            } else if (obj instanceof PeTransAmountRes) {
//                return peResultConverter.convertPeTransAmountRes((PeTransAmountRes) obj, initID);
//            }
//            return obj;
//        } catch (Exception e) {
//            log.error("[{}] 结果类型转换失败, exception happen:", initID, e);
//            throw new PortalException(ResponseCodeConstant.OBJECT_CONVERT_FAILED.getResponseCode(),
//                    ResponseCodeConstant.OBJECT_CONVERT_FAILED.getResponseDesc() + ":结果类型转换失败。", e, initID);
//        }
        return null;
    }

    public ExternalResponse convert(PayResponseWrapper wrapper) {
        ExternalResponse<Object> externalResponse = new ExternalResponse<Object>();
//        if (null != wrapper.getPeResponse().getErrorCode()) {
//            String errorCode = ResponseCodeUtil.translateResCode(wrapper.getPeResponse().getErrorCode());
//            externalResponse.setErrorCode(errorCode);
//            ResponseCodeConstant responseCodeConstant = ResponseCodeConstant.explainByResCode(errorCode);
//            externalResponse.setErrorMsg(responseCodeConstant == null ? wrapper.getPeResponse().getErrorMsg() : responseCodeConstant.getResponseDesc());
//            externalResponse.setResult(convertResult(wrapper.getPeResponse().getResult(), wrapper.getPayRequestWrapper().getPayRequest().getInitiationID()));
//        } else {
//            log.error("[{}] 交易失败！ 返回错误编码为空！", wrapper.getPayRequestWrapper().getPayRequest().getInitiationID());
//            externalResponse.setErrorCode(ResponseCodeConstant.SYS_EXCEPTION.getResponseCode());
//            externalResponse.setErrorMsg(ResponseCodeConstant.SYS_EXCEPTION.getResponseDesc());
//        }
        return externalResponse;
    }
}
