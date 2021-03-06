package com.intergration.test.integration.commonflow.service.handler;

import com.alibaba.dubbo.rpc.RpcException;
import com.google.common.base.Throwables;
import com.intergration.test.constant.ResponseCodeConstant;
import com.intergration.test.exception.IntergrationException;
import com.intergration.test.model.response.base.ExternalResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
@Service
@Slf4j
public class ExceptionHandleService {
    public ExternalResponse<String> handle(Message<Exception> msg) {
        ExternalResponse<String> externalResponse = new ExternalResponse<String>();
        try {
            if (msg.getPayload() instanceof MessageHandlingException) {
                MessageHandlingException e = (MessageHandlingException) msg.getPayload();
                //头部信息获取
                GenericMessage genericMessage = (GenericMessage) e.getFailedMessage();
                MessageHeaders messageHeaders = genericMessage.getHeaders();
                String keep = messageHeaders.get("keep") != null ? messageHeaders.get("keep").toString() : "";
                String appname = messageHeaders.get("appname") != null ? messageHeaders.get("appname").toString() : "";
                String all = keep + "," + appname;

                if (null != e.getCause() && e.getCause() instanceof IntergrationException ) {
                    IntergrationException intergrationException = (IntergrationException) e.getCause();


                    log.info("[{}] ============进入异常流程(自定义intergrationException)============ \n ResponseCode:{},ResponseDesc:{}", all, intergrationException.getCode(), intergrationException.getMessage());
                    Throwable cause = intergrationException.getCause();
                    if (cause instanceof RpcException) {
                        RpcException rpcException = (RpcException) cause;
                        if (RpcException.TIMEOUT_EXCEPTION == rpcException.getCode()) {
                            externalResponse.setCode(ResponseCodeConstant.PROCESSING.getResponseCode());
                            externalResponse.setMsg(ResponseCodeConstant.PROCESSING.getResponseDesc());
                            log.info("[{}] ============进入异常流程,RpcException异常(自定义intergrationException)--结束============", all);
                            return externalResponse;
                        }
                    }
                    log.error("[{}] [ExceptionHandleService]交易失败！\n ResponseCode:{},ResponseDesc:{}, \n cause:[{}]",
                            all, intergrationException.getCode(), intergrationException.getMessage(), Throwables.getStackTraceAsString(e));
                    externalResponse.setCode(intergrationException.getCode());
                    externalResponse.setMsg(intergrationException.getMessage());
                    return externalResponse;
                }
            }
        } catch (Exception e) {
            log.error("============[ExceptionHandleService]异常流程处理失败============", e, msg.toString());
        }
        externalResponse.setCode(ResponseCodeConstant.SYS_EXCEPTION.getResponseCode());
        externalResponse.setMsg(ResponseCodeConstant.SYS_EXCEPTION.getResponseDesc());
        log.info("============进入异常流程(非自定义intergrationException)============", msg.toString());
        return externalResponse;
    }
}
