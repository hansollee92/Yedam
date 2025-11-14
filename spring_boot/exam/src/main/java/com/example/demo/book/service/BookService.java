package com.example.demo.book.service;

import java.util.List;

public interface BookService {

	// 등록
	int insert(BookVO book);
	
	// 전체조회
	List<BookVO> getList();
	
	// 단건조회 
	BookVO getBook(Long bookNo);
	
	// 도서대여조회
	List<BookVO> getRental();
	
}
