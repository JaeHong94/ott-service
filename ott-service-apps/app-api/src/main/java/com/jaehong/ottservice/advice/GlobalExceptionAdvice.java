package com.jaehong.ottservice.advice;

import com.jaehong.ottservice.controller.OttServiceApiResponse;
import com.jaehong.ottservice.exception.ErrorCode;
import com.jaehong.ottservice.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(UserException.class)
    protected OttServiceApiResponse<?> handleUserException(UserException e) {
        log.error("error={}", e.getMessage(), e);
        return OttServiceApiResponse.fail(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    protected OttServiceApiResponse<?> handleRuntimeException(RuntimeException e) {
        log.error("error={}", e.getMessage(), e);
        return OttServiceApiResponse.fail(ErrorCode.DEFAULT_ERROR, e.getMessage());
    }
}
