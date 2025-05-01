package com.jaehong.ottservice.controller.movie;

import com.jaehong.ottservice.exception.ErrorCode;

public record OttServiceApiResponse<T>(
        boolean success,
        String code,
        String message,
        T data
) {
    public static final String CODE_SUCCESS = "SUCCEED";

    public static <T> OttServiceApiResponse<T> ok(T data) {
        return new OttServiceApiResponse<>(true, CODE_SUCCESS, null, data);
    }

    public static <T> OttServiceApiResponse<T> fail(ErrorCode errorCode, String message) {
        return new OttServiceApiResponse<>(false, errorCode.getCode(), message, null);
    }
}
