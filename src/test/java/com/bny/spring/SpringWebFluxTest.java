package com.bny.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringWebFluxTest {

	@Autowired
	private WebTestClient webTestClient;

	
	@Test
	public void testHelloWorld() {
		webTestClient
		.get().uri("/books/1") // GET method and URI
		.accept(MediaType.APPLICATION_JSON) //setting ACCEPT-Content
		.exchange() //gives access to response
		.expectStatus().isOk() //checking if response is OK
		.expectBody(String.class).isEqualTo("Hello World!"); // checking for response type and message
	}

}
