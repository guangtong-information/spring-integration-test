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
    REQUEST_VALID("000003","请求参数合法"),
    REQUEST_ILLEGAL("040001", "请求参数非法"),

    /**
     * 外部编码
     */
    SUCCESS("000000", "成功"),
    FAIL("880003", "失败"),
    PROCESSING("880001", "交易处理中"),
    SYS_EXCEPTION("991001", "系统异常"),
    ;


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
