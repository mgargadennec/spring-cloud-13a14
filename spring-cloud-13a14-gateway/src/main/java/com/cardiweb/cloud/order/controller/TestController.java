package com.cardiweb.cloud.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	@Output(Source.OUTPUT)
	MessageChannel messageChannel;

	@RequestMapping(method = RequestMethod.GET, value = "/send-message")
	public void test(@RequestParam("message") String message) {
		messageChannel.send(MessageBuilder.withPayload(message).build());
	}

}
