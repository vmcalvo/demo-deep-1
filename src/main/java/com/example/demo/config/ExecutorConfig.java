package com.example.demo.config;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@Configuration
public class ExecutorConfig extends AsyncConfigurerSupport {
    @Override
    @Bean
    @Primary
    public Executor getAsyncExecutor() {
        ContextAwarePoolExecutor executor = new ContextAwarePoolExecutor();
        executor.setThreadNamePrefix("ContextAwareExecutor");
		return executor;
    }
}
