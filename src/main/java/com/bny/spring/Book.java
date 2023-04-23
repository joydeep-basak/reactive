package com.bny.spring;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
	private int id;
	private String name;
	public Book() {}
	public Book(String name) {
		this.name = name;
	}
	public Book(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
