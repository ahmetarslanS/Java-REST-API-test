package com.beginsecure.messenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.beginsecure.messenger") // Add this line
public class MessengerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerAppApplication.class, args);
	}
}
