package com.yash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.BooksRepository;
import com.yash.model.Books;

@Service
public class BooksService {
	@Autowired  
	BooksRepository booksRepository;  
	
	public List<Books> getAllBooks()   
	{  
	
	List<Books> books = new ArrayList<Books>(); 
	try {
	booksRepository.findAll().forEach(books1 -> books.add(books1));  
		}
		catch (Exception e) {
			System.out.println("Exception while adding  books");
		}
	return books;  
	}  

	public Books getBooksById(int id)   
	{  
	return booksRepository.findById(id).get();  
	}  

	public void saveOrUpdate(Books books)   
	{  
		try {
	booksRepository.save(books);  
		}
		catch (Exception e) {
			System.out.println("Exception while modifying  books");
		}
	}  
 
	public String delete(int bookid)   
	{  
		
		boolean flag = false;
		try {
			
	booksRepository.deleteById(bookid);  
	flag = true;
			

	}
		catch (Exception e) {
			System.out.println("Exception while deleting  books");
		}
		if (flag) {
			return "book deleted Successfully with id= " + bookid;
		} else {
			return "id " + bookid + " does not exist";
		}
		
	}  
	
	public void update(Books books, int bookid)   
	{  
		try {
	booksRepository.save(books);  
		}
		catch (Exception e) {
			System.out.println("Exception while modifying  books");
		}
		
	}  
	}  