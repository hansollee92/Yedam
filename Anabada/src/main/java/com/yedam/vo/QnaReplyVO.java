package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class QnaReplyVO {

	private int qnaReplyNo;             //문의 댓글번호
	private String qnaReplyContent;     //문의 댓글내용
	private Date qnaReplyDate;          //날짜
	private int qnaNo;      
	private int memberNo; 	
	
}
