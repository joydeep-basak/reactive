package com.bny.spring;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class BookHandler {
	@Autowired
	private BookService bookService;
	
	public Mono<ServerResponse> getBookById(ServerRequest request) {
		int id = Integer.parseInt(request.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
			.body(BodyInserters.fromValue(bookService.getBookById(id)));
	}
	public Mono<ServerResponse> createBook(ServerRequest request) {
		
//		
		return request.bodyToMono(Book.class).flatMap(book -> ServerResponse.created(URI.create("/create"))
				.contentType(MediaType.APPLICATION_JSON).bodyValue(bookService.createBook(book)));
				
//		
	}
}