package com.example.demo.config;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class ContextAwareRunnable implements Runnable {
	private Runnable task;
	private RequestAttributes context;

	public ContextAwareRunnable(Runnable task, RequestAttributes context) {
		this.task = task;
		this.context = context;
	}

	@Override
	public void run() {
		if (context != null) {
			RequestContextHolder.setRequestAttributes(context);
		}

		try {
			task.run();
		} finally {
			RequestContextHolder.resetRequestAttributes();
		}

	}
}