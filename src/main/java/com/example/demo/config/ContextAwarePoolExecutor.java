package com.example.demo.config;


import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.context.request.RequestContextHolder;

public class ContextAwarePoolExecutor extends ThreadPoolTaskExecutor {

	private static final long serialVersionUID = 1L;

	@Override
	public void execute(Runnable task) {
		super.execute(new ContextAwareRunnable(task, RequestContextHolder.currentRequestAttributes()));
	}
}