package com.bny.spring;

import org.springframework.stereotype.Service;

@Service
public class BookService {
	public Book getBookById(int id) {
        return new Book(id, "Spring Tutorials");
	}
	public Book createBook(Book book) {
		return new Book(102, book.getName());
	}
}