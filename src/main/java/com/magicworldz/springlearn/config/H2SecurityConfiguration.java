package com.magicworldz.springlearn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1000)
@Profile("!prod")
//@Profile("!a & !b")
public class H2SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.antMatcher("/h2-console/**").authorizeRequests().anyRequest().permitAll();
		 http.csrf().disable();
		 http.headers().frameOptions().disable();

	}
}