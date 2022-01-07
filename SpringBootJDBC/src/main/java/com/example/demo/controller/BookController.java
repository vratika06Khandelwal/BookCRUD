package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Book;
import com.example.demo.dao.BookJdbcDao;
@RestController
public class BookController {
	
	@Autowired
	private BookJdbcDao bookJdbcDao;
	
	@GetMapping("/totalBook")
	public int countBooks() {
           return bookJdbcDao.count();
	}
	
	@PostMapping("/SaveBook")
	public int saveBook(@RequestBody Book book) {
	
		return bookJdbcDao.save(book);
	}
	
	@PutMapping("/updateBook")
	public int updateBook(@RequestBody Book book) {
		return bookJdbcDao.update(book);
	}
	
	@GetMapping("/Books")
	public List<Book> getAll(Book book) {
		return bookJdbcDao.findAll();
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public int deleteBook(@PathVariable int id){
		return bookJdbcDao.deleteById(id);
	}
	
	@GetMapping("/Books/{name}/{price}")
	public List<Book> getBook(@PathVariable String name,@PathVariable Double  price) {
		return bookJdbcDao.findByNameAndPrice(name, price);
	}
	
	@GetMapping("/Name/{id}")
	public String getName(@PathVariable int id){
		return bookJdbcDao.getNameById(id);
	}
}
