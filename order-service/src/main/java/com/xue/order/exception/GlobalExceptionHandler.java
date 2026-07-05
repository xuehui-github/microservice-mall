package com.xue.order.exception;

import com.xue.order.vo.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception e) {
        log.error("unexpected error", e);
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务器内部错误");
    }
}
