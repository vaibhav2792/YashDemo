package com.yash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Books;
import com.yash.service.BooksService;

@RestController
public class BooksController {
	@Autowired  
	BooksService booksService;  
	  
	@GetMapping("/book")  
	private List<Books> getAllBooks()   
	{  
	return booksService.getAllBooks();  
	}  
  
	@GetMapping("/book/{bookid}")  
	private Books getBooks(@PathVariable("bookid") int bookid)   
	{  
	return booksService.getBooksById(bookid);  
	}  
	
	@DeleteMapping("/book/{bookid}")  
	private String deleteBook(@PathVariable("bookid") int bookid)   
	{  
	return booksService.delete(bookid);
	}  

	@PostMapping("/books")  
	private int saveBook(@RequestBody Books books)   
	{  
	booksService.saveOrUpdate(books);  
	return books.getBookid();  
	}  

	@PutMapping("/updatebooks")  
	private Books update(@RequestBody Books books)   
	{  
	booksService.saveOrUpdate(books);  
	return books;  
	}  
	}  