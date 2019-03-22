package com.intergration.test.integration.transflow.wrapper;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class BaseRequestWrapper {

    private boolean isComplete;

    private String errorMsg;

    private String errorCode;

}
