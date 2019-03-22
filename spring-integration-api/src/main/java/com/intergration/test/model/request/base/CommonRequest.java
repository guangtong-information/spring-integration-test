package com.intergration.test.model.request.base;

import lombok.Data;

import java.io.Serializable;


@Data
public class CommonRequest implements Serializable {
    private static final long serialVersionUID = -449603975016674678L;
    /**
     * 发起流水号
     */
    private String keep;
}
