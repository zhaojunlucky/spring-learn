package com.exia.aop.service.impl;

import com.exia.aop.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello(String name) {
        log.info("hello for {}", name);
        return "Hello " + name + "!!!";
    }
}
