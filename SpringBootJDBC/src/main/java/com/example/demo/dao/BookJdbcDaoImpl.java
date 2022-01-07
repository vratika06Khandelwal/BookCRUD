package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Book;

@Repository
public class BookJdbcDaoImpl implements BookJdbcDao{
	
	    @Autowired
	    private JdbcTemplate jdbcTemplate;

	    @Override
	    public int count() {
	        return jdbcTemplate
	                .queryForObject("select count(*) from books", Integer.class);
	    }

	    @Override
	    public int save(Book book) {
	        return jdbcTemplate.update(
	                "insert into books (BookId,BookName,BookPages,BookPrice,BookAuthorName) values(?,?,?,?,?)",
	              book.getBookId(),  book.getBookName(),book.getBookPages(), book.getBookPrice(),book.getBookAuthorName());
	    }

	    @Override
	    public int update(Book book) {
	        return jdbcTemplate.update(
	                "update books set BookPrice = ? where BookId = ?",
	                book.getBookPrice(), book.getBookId());
	    }


	    @Override
	    public int deleteById(int id) {
	        return jdbcTemplate.update(
	                "delete books where BookId = ?",
	                id);
	    }

	    @Override
	    public List<Book> findAll() {
	        return jdbcTemplate.query(
	                "select * from books",
	                (rs, rowNum) ->
	                        new Book(
	                              rs.getInt("BookID"),
	                              rs.getString("BookName"),
	                              rs.getInt("BookPages"),
	                              rs.getFloat("BookPrice"),
	                              rs.getString("BookAuthorName")
	                        )
	        );
	    }

	   

	    @SuppressWarnings("deprecation")
		@Override
	    public List<Book> findByNameAndPrice(String name, Double price) {
	        return jdbcTemplate.query(
	                "select * from books where BookName like ? and BookPrice <= ?",
	                new Object[]{"%" + name + "%", price},
	                (rs, rowNum) ->
	                        new Book(
	                        		rs.getInt("BookID"),
		                              rs.getString("BookName"),
		                              rs.getInt("BookPages"),
		                              rs.getFloat("BookPrice"),
		                              rs.getString("BookAuthorName")
	                        )
	        );
	    }

	    @SuppressWarnings("deprecation")
		@Override
	    public String getNameById(int id) {
	        return jdbcTemplate.queryForObject(
	                "select BookName from books where BookId = ?",
	                new Object[]{id},
	                String.class
	        );
	    }

		
	

}
