package com.exia.aop.runner;

import com.exia.aop.service.HelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class HelloWorldRunner implements CommandLineRunner {
    private final HelloWorldService helloWorldService;

    public HelloWorldRunner(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }


    @Override
    public void run(String... args) {
        log.info("runner - before call");
        log.info("runner - result: {}", helloWorldService.sayHello("jun"));
        log.info("runner - after call");

    }
}
