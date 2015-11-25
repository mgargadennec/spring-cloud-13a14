package com.cardiweb.cloud.order.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cardiweb.cloud.order.client.UserClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	private static final Logger logger = LoggerFactory
			.getLogger(TestController.class);

	@Autowired
	private UserClient userClient;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public String test() {
		String testedOrder = userClient.getWhoAmI();
		return "ceci est un test d'order --> order who am I = {}" + testedOrder;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/test2")
	@HystrixCommand(fallbackMethod = "cantContactUserApp")
	public String test2() {
		return restTemplate.exchange("http://user/whoami", HttpMethod.GET, null, String.class).getBody();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/whoami")
	public String whoami(HttpServletRequest request) {
		return "I am an order server : " + request.getRequestURL();
	}

	public String cantContactUserApp() {
		return "Can't contact users :(";
	}
}
