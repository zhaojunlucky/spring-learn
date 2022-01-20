package com.magicworldz.springlearn.exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/exception")
@Slf4j
public class ControllerAdviceExceptionController implements ControllerAdviceExceptionHandlerMixin {
    @RequestMapping("advice")
    public String testException() {
        log.info("test controller advice exception");
        throw new CustomerRuntimeException("test controller advice exception");
    }
}