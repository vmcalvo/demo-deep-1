package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.interceptor.SecurityFeignRequestInterceptor;

import feign.RequestInterceptor;

@Configuration
public class Config {
	
	@Bean
    public RequestInterceptor securityFeignRequestInterceptor() {
        return new SecurityFeignRequestInterceptor();
    }

}
