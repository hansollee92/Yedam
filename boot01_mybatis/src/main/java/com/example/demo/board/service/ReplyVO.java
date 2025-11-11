package com.example.demo.board.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class ReplyVO {
	
	// 필드
	private Long rno;
	private Long bno;
	private String reply;
	
	//@JsonProperty(value = "writer")
	private String replyer;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date replydate;
	
	@JsonIgnore
	private Date updatedate;
	
}
