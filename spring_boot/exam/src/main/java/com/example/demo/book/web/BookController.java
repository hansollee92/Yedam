package com.example.demo.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.book.service.BookService;
import com.example.demo.book.service.BookVO;


@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	// 전체조회
	@GetMapping("/book")
	public String selectall(Model model) {
		model.addAttribute("book", bookService.getList());
		return "book";
	}
	
	// 등록페이지 이동
	@GetMapping("/register")
	public String registerpage() {
		return "register";
	}
	
	// 등록처리 
	@PostMapping("/register")
	public String register(BookVO book) {
		bookService.insert(book);
		return "redirect:/book";
	}
		
	// 단건조회
	@GetMapping("/info")
	public void info(@RequestParam("bookNo") Long bookNo, Model model) {
		model.addAttribute("book", bookService.getBook(bookNo));
	}
	
	// 대여조회페이지 이동
	@GetMapping("/rental")
	public String rentalpage(Model model) {
		model.addAttribute("book", bookService.getRental());
		return "rental";
	}
	
	
}
