package com.mojie.demo.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CallbackController {
	
	protected static final Logger logger = LoggerFactory.getLogger(CallbackController.class);
	
	@RequestMapping(value = "/callback", method = RequestMethod.POST)
	public void callback(@RequestBody String body, ServletRequest request, ServletResponse response) {
		logger.info("callback processed");
	}

}
