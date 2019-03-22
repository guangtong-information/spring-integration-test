package com.intergration.test.model.response.base;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Winlone
 */
@Data
@ToString(callSuper = true)
public class CommonResponse<T>  implements Serializable {

    private static final long serialVersionUID = -3214885479484534221L;

    private T result;  //获取调用返回值

    private String code; //获取错误码

    private String msg;

}
