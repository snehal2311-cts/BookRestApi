package com.cts.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.cts.model.Book;
import com.cts.service.BookService;


@RestController
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> findAll(){
		return bookService.findAll();
	}
	
	//getting from id
	@GetMapping("/{id}")
	public Optional<Book> findById(@PathVariable Long id){
		
		return bookService.findById(id);
	}
	
	//create a book
	
	@ResponseStatus(HttpStatus.CREATED)  //201
    @PostMapping
    public Book create(@RequestBody Book book) {
    	return bookService.save(book);
    }
	
	//delete a book from id
	@ResponseStatus(HttpStatus.NO_CONTENT)  //204
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		bookService.deleteById(id);
	}
	
	//getting a book from title
	
	@GetMapping("/find/title/{title}")
	public List<Book> findByTitle(@PathVariable String title){
		return bookService.findByTitle(title);
	}
	
	//getting book from published date
	
	@GetMapping("/find/date-after/{date}")
	public List<Book> findByPublishedDateAfter(@PathVariable LocalDate date){
		return bookService.findByPublishedDateAfter(date);
	}
	

}
