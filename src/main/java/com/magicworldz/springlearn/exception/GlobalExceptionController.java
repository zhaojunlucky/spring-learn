package com.magicworldz.springlearn.exception;

import com.magicworldz.springlearn.exception.entity.CustomerRuntimeException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/exception")
@Slf4j
public class GlobalExceptionController {
    @RequestMapping("global")
    public String testExp() {
        log.info("test expcetion");
        throw new CustomerRuntimeException("test exception|全局异常测试 - global handler");
    }
}