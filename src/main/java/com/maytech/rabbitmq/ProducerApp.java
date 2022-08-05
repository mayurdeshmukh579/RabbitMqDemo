package com.maytech.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.AMQP.Channel;


public class ProducerApp {	
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory conFactory = new ConnectionFactory();
		
		try(Connection connection = conFactory.newConnection();){
			
			com.rabbitmq.client.Channel channel = connection.createChannel();
			
			String mesg = "Hello Everyone";
			channel.basicPublish("", "test", null, mesg.getBytes());
			
			System.out.println("Message publish to the queue");
		}
		
		System.out.println("hwuhdhqd"); 
	}
}
