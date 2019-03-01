package com.xcy.wolf.exception;

import com.xcy.wolf.enums.ApiErrorEnum;

/**
 * @author xcy
 * @date 2019/02/27 17:18
 * @description
 * @since V1.0.0
 */
public class ApiException extends RuntimeException{
    private static final long serialVersionUID = -5259678926245125943L;

    private ApiErrorEnum error;

    public ApiException(ApiErrorEnum error) {
        super(error.getDescription());
        this.error = error;
    }

    public ApiErrorEnum getError() {
        return error;
    }
}
