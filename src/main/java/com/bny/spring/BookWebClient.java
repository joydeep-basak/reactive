package com.bny.spring;

import org.springframework.web.reactive.function.client.WebClient;

public class BookWebClient {
	private WebClient client = WebClient.create("http://localhost:8080");

	public void fetchBookByIdDemo() {
		  int id = 101;
		  client.get()
				.uri("/books/" + id)
				.exchange()	
		        .flatMap(res -> res.bodyToMono(String.class))
		        .subscribe(book -> System.out.println("GET: " + book));
	}
	public void createBookDemo() {
		  client.post()
				.uri("/create")
				.bodyValue(new Book("Android"))
				.exchange()
		        .flatMap(res -> res.bodyToMono(Book.class))
				.subscribe(book -> System.out.println(book)); 
	}	
}