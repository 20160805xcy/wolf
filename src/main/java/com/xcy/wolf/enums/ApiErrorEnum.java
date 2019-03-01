package com.xcy.wolf.enums;

/**
 * @author xcy
 * @date 2019/02/27 17:13
 * @description
 * @since V1.0.0
 */
public enum ApiErrorEnum {
    CODE_0(0,"error"),
    CODE_1(1,"success"),
    API_USER_1(10001,"无法获取请求Request对象"),
    API_USER_2(10002,"无法获取请求Response对象"),
    ;


    private int code;
    private String description;

    ApiErrorEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }


    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
