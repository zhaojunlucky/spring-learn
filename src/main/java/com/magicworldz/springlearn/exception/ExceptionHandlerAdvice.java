package com.magicworldz.springlearn.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magicworldz.springlearn.exception.entity.CustomerRuntimeException;
import com.magicworldz.springlearn.exception.entity.ErrorCode;
import com.magicworldz.springlearn.exception.entity.ResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

// if do not set assignableTypes, it will take efftect on all controllers
@ControllerAdvice(assignableTypes = {ControllerAdviceExceptionHandlerMixin.class})
@Slf4j
public class ExceptionHandlerAdvice {
    @ExceptionHandler({CustomerRuntimeException.class})
    @ResponseBody
    public ResponseDTO<?> exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error("[{}] System error", e);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseDTO.fail(ErrorCode.SYSTEM_ERROR.getErrCode(), e.getMessage());
    }
}