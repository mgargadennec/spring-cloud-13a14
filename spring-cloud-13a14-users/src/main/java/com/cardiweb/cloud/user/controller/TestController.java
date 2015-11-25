package com.cardiweb.cloud.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Trace;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cardiweb.cloud.user.client.OrderClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	 
	@Autowired
	private Trace trace;
	
	@Autowired
	private OrderClient orderClient;

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	@HystrixCommand(fallbackMethod = "cantContactOrderApp")
	public String test(){
		String testedOrder=orderClient.getWhoAmI();
		trace.addAnnotation("tested-order", testedOrder);
		return "ceci est un test d'user --> order who am I = {}"+ testedOrder;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/whoami")
	public String whoami(HttpServletRequest request){
		return "I am a user server : "+request.getRequestURL();
	}
	

	public String cantContactOrderApp(){
		return "Can't contact orders :(";
	}
}
