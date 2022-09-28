package com.yash.dao;

import org.springframework.data.repository.CrudRepository;

import com.yash.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer>{

}
