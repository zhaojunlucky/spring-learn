package com.magicworldz.springmisc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Config {
    @Value("#{${config.map}}")
    private Map<String, String> map;
}
