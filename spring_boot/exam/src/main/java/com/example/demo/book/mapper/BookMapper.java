package com.example.demo.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.book.service.BookVO;

@Mapper
public interface BookMapper {

	// 등록
	int insert(BookVO book);
	
	// 전체조회
	List<BookVO> getList();
	
	// 단건조회 
	BookVO getBook(Long bookNo);
	
	// 도서대여조회
	List<BookVO> getRental();
	
}
