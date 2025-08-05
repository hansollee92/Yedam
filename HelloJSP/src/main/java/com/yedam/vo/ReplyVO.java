package com.yedam.vo;

import lombok.Data;

@Data
public class ReplyVO {
	
	//필드
	private int replyNo;
	private int boardNo;
	private String reply;
	private String replyer;
	private String replyDate;
}
