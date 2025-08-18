package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class QnaVO {

	private int qnaNo;             //문의번호
	private String qnaTitle;       //제목
	private String qnaContent;     //내용
	private Date qnaDate;          //작성일
	private int memberNo;          
	private int prdNo;	
	private String memberId;       //join을 위해 필요한 필드값
	
}
