package com.yedam.vo;

import lombok.Data;

@Data
public class CommuReplyVO {
	private int commuReplyNo;         // 글댓글번호
    private String commuReplyContent; // 댓글 내용
    private Date commuReplyDate;      // 작성일
    private int parentId;             // 상위 댓글 번호
    private int memberNo;             // 작성자 회원번호
    private int commuNo;              // 게시글 번호
}
