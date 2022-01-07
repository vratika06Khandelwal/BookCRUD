package com.example.demo.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
