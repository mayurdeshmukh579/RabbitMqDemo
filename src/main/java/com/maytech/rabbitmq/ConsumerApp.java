package com.maytech.rabbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class ConsumerApp {
	public static void main(String[] args) throws IOException, TimeoutException{
		
		ConnectionFactory conFactory = new ConnectionFactory();
		
		Connection connection = conFactory.newConnection();
		
		Channel channel = connection.createChannel();
		
		Consumer consumer = new DefaultConsumer(channel) {
			
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				
				System.out.println("Message body :-"+ new String(body));
			}
		};
		
		channel.basicConsume("test", consumer);
		
	}
}
