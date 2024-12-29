package com.itzeng.springbootstoptool.exception;

import com.itzeng.springbootstoptool.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)//捕获所有的异常
    public Result ex(Exception e) {
        e.printStackTrace();
        return Result.error("对不起，操作失败",500);
    }
}
