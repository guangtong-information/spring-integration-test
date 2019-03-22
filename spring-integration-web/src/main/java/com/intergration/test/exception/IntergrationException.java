package com.intergration.test.exception;

import lombok.Getter;

/**
 * Created by winlone
 * Date: 2016-8-8.
 */
public class IntergrationException extends RuntimeException {

    private static final long serialVersionUID = 1165876351848409310L;
    @Getter
    private String code;
    @Getter
    private String initID;

    public IntergrationException(String code, String message) {
        super(message);
        this.code = code;
    }

    public IntergrationException(String code, String message, String initID) {
        super(message);
        this.code = code;
        this.initID = initID;
    }

    public IntergrationException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public IntergrationException(String code, String message, Throwable throwable, String initID) {
        super(message, throwable);
        this.code = code;
        this.initID = initID;
    }

    //覆盖方法，不打印错误堆栈
    public Throwable fillInStackTrace() {
        return null;
    }

}
