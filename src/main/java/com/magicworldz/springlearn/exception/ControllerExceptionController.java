package com.magicworldz.springlearn.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magicworldz.springlearn.exception.entity.CustomerRuntimeException;
import com.magicworldz.springlearn.exception.entity.ErrorCode;
import com.magicworldz.springlearn.exception.entity.ResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("api/exception")
public class ControllerExceptionController {

    @ExceptionHandler({Exception.class, CustomerRuntimeException.class})
    public ResponseDTO<?> exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        log.error("[{}] System error", e);
        log.info("request {}", request.getContextPath());
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseDTO.fail(ErrorCode.SYSTEM_ERROR.getErrCode(), e.getMessage());
    }

    @RequestMapping("controller")
    public String testController() {
        log.info("test controller exception handler - controller");
        throw new CustomerRuntimeException("test controller exception handler - controller");
    }
}