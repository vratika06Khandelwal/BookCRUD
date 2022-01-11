package com.example.demo.bean;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor


public class Book {
	
	private int bookId;
	private String bookName;
	private int bookPages;
	private double bookPrice;
	private String bookAuthorName;
	
}
