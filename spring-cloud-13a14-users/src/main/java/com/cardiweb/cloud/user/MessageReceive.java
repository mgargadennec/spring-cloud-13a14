package com.cardiweb.cloud.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public  class MessageReceive{
	private static final Logger logger = LoggerFactory.getLogger(MessageReceive.class);
	
	@ServiceActivator(inputChannel=Sink.INPUT)
	public void accept(String message){
		System.err.println("Received message by user <"+message+">");
	}
} 