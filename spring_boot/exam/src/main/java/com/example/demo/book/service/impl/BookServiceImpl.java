package com.example.demo.book.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.book.mapper.BookMapper;
import com.example.demo.book.service.BookService;
import com.example.demo.book.service.BookVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookMapper bookMapper;
	
	@Override
	public int insert(BookVO book) {
		return bookMapper.insert(book);
	}

	@Override
	public List<BookVO> getList() {
		return bookMapper.getList();
	}

	@Override
	public BookVO getBook(Long bookNo) {
		return bookMapper.getBook(bookNo);
	}

	@Override
	public List<BookVO> getRental() {
		return bookMapper.getRental();
	}

}
