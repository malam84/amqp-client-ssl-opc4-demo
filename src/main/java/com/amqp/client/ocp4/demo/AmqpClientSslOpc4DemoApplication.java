package com.amqp.client.ocp4.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class AmqpClientSslOpc4DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AmqpClientSslOpc4DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		sendMessage("Hello World!");
	}

	public void sendMessage(String text) {
		System.out.println(String.format("Sending '%s'", text));
		this.jmsTemplate.convertAndSend("testQueue", text);
	}

	@JmsListener(destination = "testQueue")
	public void receiveMessage(String text) {
		System.out.println(String.format("Received '%s'", text));
	}

}
