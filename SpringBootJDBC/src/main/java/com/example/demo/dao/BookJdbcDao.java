package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.bean.Book;

public interface BookJdbcDao {
	    public int count();
 
	    public int save(Book book);

	    public int update(Book book);

	    public int deleteById(int id);
	    
	    public int deleteAll();
	    public int updateAll();

	    public List<Book> findAll();

	    public List<Book> findByNameAndPrice(String name, Double price);

	  

	    public String getNameById(int id);

}
