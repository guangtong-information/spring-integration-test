package com.intergration.test.constant;

import com.google.common.base.Objects;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
public enum ResponseCodeConstant {

    /**
     * 内部编码
     */
    REQUEST_VALID("BPPE00000003","请求参数合法"),


    /**
     * 外部编码
     */
    SUCCESS("BPPE04000000", "成功"),
    FAIL("BPPE04880003", "失败"),
    PROCESSING("BPPE04880001", "交易处理中"),
    SYS_EXCEPTION("BPPE04991001", "系统异常"),
    REMOTE_RESPONSE_NULL_EXCEPTION("BPPE04880015", "系统异常，请确认请求是否成功再尝试发起"),
    DUBBO_TIME_OUT("BPPE04880016","调用远程超时"),
    REQUEST_ILLEGAL("BPPE04880002", "请求参数非法"),
    TIME_OUT("BPPE04880022","业务处理超时"),
    OBJECT_CONVERT_FAILED("BPPE04880005", "对象格式转换失败");


    /**
     * 定义常量
     */



    private final String responseCode;
    private final String responseDesc;

    /**
     * 获取描述信息
     *
     * @param resCode
     * @return
     */
    public static ResponseCodeConstant explainByResCode(String resCode) {
        for (ResponseCodeConstant responseCodeConstant : ResponseCodeConstant.values()) {
            if (Objects.equal(resCode, responseCodeConstant.responseCode)) {
                return responseCodeConstant;
            }
        }
        return null;
    }

    ResponseCodeConstant(String responseCode, String responseDesc) {
        this.responseCode = responseCode;
        this.responseDesc = responseDesc;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseDesc() {
        return responseDesc;
    }
}
