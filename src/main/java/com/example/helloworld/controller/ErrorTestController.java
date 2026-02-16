package com.example.helloworld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorTestController {

	private static final Logger logger = LoggerFactory.getLogger(ErrorTestController.class);

	@GetMapping("/error")
	public String triggerError() {
		logger.error("Intentional error triggered at /error endpoint for testing");
		throw new RuntimeException("Intentional test exception from /error endpoint - "
				+ "used for testing logging, distributed tracing, and error handling");
	}

}
