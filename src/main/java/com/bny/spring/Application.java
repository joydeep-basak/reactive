package com.bny.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		BookWebClient bwc = new BookWebClient();
		bwc.fetchBookByIdDemo();
		bwc.createBookDemo();
	}
}