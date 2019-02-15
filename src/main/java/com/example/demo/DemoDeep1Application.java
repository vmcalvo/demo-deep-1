package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;


import com.example.demo.service.TareaAsincrona;



@SpringBootApplication
@EnableFeignClients
@EnableOAuth2Client
public class DemoDeep1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoDeep1Application.class, args);
	}

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	@Bean
	public TareaAsincrona getTareaAsicrona() {
		return new TareaAsincrona();

	}


}
