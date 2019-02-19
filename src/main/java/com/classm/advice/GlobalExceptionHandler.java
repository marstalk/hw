package com.classm.advice;

import com.classm.bean.JsonEntity;
import com.classm.bean.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice(basePackages = "com.classm.controller")
@RestController
public class GlobalExceptionHandler {


    @ExceptionHandler(BizExceptiton.class)
    public JsonEntity<String> BizExceptionHandle(BizExceptiton e){
        return ResponseHelper.error(-1, e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public JsonEntity<String> ExceptionHandle(Exception e, HttpServletResponse response){
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseHelper.error(-99, e.getMessage());
    }



}
