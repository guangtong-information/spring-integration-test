package com.intergration.test.unit.base;

import lombok.Getter;


public enum Profile {
    DUBBO("dubbo"),
    MOCK("default"),
    LOCAL("local");

    @Getter
    private String value;

    Profile(String value) {
        this.value = value;
    }
}
