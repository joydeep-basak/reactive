package com.bny.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class BookRouter {
	@Bean
	public RouterFunction<ServerResponse> root(BookHandler bookHandler) {
		return RouterFunctions.route()
		  .GET("/books/{id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), bookHandler::getBookById)
		  .POST("/create", RequestPredicates.contentType(MediaType.APPLICATION_JSON), bookHandler::createBook)
		  .build();
	}
}