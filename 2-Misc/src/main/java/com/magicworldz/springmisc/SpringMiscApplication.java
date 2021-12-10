package com.magicworldz.springmisc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SpringMiscApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMiscApplication.class, args);
	}

}
