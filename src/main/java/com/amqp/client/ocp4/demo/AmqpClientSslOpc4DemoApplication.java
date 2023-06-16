package com.amqp.client.ocp4.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;

@EnableJms
@EnableScheduling
@SpringBootApplication
public class AmqpClientSslOpc4DemoApplication implements CommandLineRunner{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(AmqpClientSslOpc4DemoApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		sendMessage("Hello World!");
	}

	/* public void sendMessage(String text) throws InterruptedException {
		System.out.println(String.format("Sending '%s'", text));
		for(int i=0; i<100; i++) {
			Thread.sleep(1000);
		this.jmsTemplate.convertAndSend("TEST", text);
		}
	} */
	
	@Scheduled(fixedDelay = 1000)
	public void performTask() {
		System.out.println("==========================Test" +jmsTemplate);
		try {
		    jmsTemplate.convertAndSend("hello");
		    System.out.println("=================mesg send========");
		}catch(JmsException e) {
			System.out.println(e.getStackTrace());
		}
	}

//	@JmsListener(destination = "TEST")
//	public void receiveMessage(String text) {
//		System.out.println(String.format("Received '%s'", text));
//	}

}
