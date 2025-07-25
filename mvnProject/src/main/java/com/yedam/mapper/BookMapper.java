package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.Book;

// --BookMapper.xml에서 만든 기능을 BookMapper interface에 규칙을 정의해서 간편하게 써보고자한다!
// 인터페이스(규칙).
public interface BookMapper {
	public Book selectBook(int id);
	public List<Book> selectList();
}
