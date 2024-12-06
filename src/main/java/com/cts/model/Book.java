package com.cts.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private BigDecimal price;
	private LocalDate publishDate;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String title, BigDecimal price, LocalDate publishDate) {
		super();
		this.title = title;
		this.price = price;
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", publishDate=" + publishDate + "]";
	}
	
	

}
