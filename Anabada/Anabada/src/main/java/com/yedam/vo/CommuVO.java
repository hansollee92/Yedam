package com.yedam.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class CommuVO {
	 private int commuNo;        // 글번호
	 private String commuTitle;  // 글제목
	 private Date commuDate;     // 작성일
	 private int memberNo;       // 작성자 회원번호 (FK)
}
