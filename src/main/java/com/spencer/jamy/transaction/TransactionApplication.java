package com.spencer.jamy.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {

		System.setProperty("server.servlet.context-path", "/api");
		SpringApplication.run(TransactionApplication.class, args);
	}

}
