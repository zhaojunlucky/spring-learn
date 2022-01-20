package com.magicworldz.springlearn.controller.helloworld;

import com.magicworldz.springlearn.utils.PasswordUtil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloWorldController {

    @RequestMapping("helloworld")
    public String helloWorld() {
        return "Hello, SpringBoot!!!" + " " + PasswordUtil.encodePassword("password123");
    }
}