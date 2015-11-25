package com.cardiweb.cloud.order;

import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public  class MessageReceive{
	
	@ServiceActivator(inputChannel=Sink.INPUT)
	public void accept(String message){
		System.err.println("Received message by orders <"+message+">");
	}
} 