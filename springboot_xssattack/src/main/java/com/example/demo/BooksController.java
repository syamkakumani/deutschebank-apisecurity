package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@RestController
public class BooksController {

	Map<Integer, Book> books = new HashMap<>();

	@PutMapping("/books/add")
	String addBooks(@Valid @RequestBody Book book) {

		books.put(book.getIsbn(), book);
		System.out.println("No of books : " + books.size());

		return "Added Book";
	}

	@GetMapping("/books/{isbnNumber}")
	String getBook(@PathVariable("isbnNumber") Integer isbn) {

		return books.get(isbn).getDescription();
	}

}

class Book {
	int isbn;

	@Pattern(regexp = "^[a-zA-Z]*$", message = "Invaid Book Name, please check")
	String name;

	@NotNull(message = "Description can't be empty")
	String description;

	public Book() {
	}

	public Book(int isbn, String name, String description) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.description = description;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
