package com.example.demo.service;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Book;
import com.example.demo.dao.BookJdbcDao;

@Service
public class BookService {
	@Autowired
	private BookJdbcDao bookDao;

	@Async
	@Scheduled(fixedRate = 30000)
	public void insertData() {

		Book book = Book.builder().bookName("Road Not Taken").bookPages(4000).bookPrice(700).bookAuthorName("Robert")
				.build();

		bookDao.save(book);
		System.out.println("The new Book is inserted:" + new Date().toString());
		
	}

	
	 @Scheduled(fixedDelay =60000 )
	 public int bookUpdate() {
	 System.out.println("The update is........"+bookDao.updateAll()+"...:"+ new
	 Date().toString());
		 return bookDao.updateAll(); 
		 }

	 @Scheduled(fixedDelay =90000)
	 public int bookCount() {
			
			 System.out.println("The count is..."+bookDao.count()+"...:"+ new
			  Date().toString()); 
			 return bookDao.count();
			 }
	  

	 @Scheduled(fixedDelay = 120000) 
	 public int bookDelete() {
			
			 System.out.println("The delete is=========="+bookDao.deleteAll()+"...:"+ new
			 Date().toString()); 
			 return bookDao.deleteAll();
			}
	 

}