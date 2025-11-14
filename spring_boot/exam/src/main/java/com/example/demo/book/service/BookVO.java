package com.example.demo.book.service;

import java.sql.Date;

import lombok.Data;

@Data
public class BookVO {

	// 필드
	private Long bookNo;
	private String bookName;
	private String bookCoverimg;
	private Date bookDate;
	private Long bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
}
