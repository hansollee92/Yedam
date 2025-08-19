package com.yedam.service;

import java.util.List;

import com.yedam.vo.QnaReplyVO;

public interface QnaReplyService {
	
	public List<QnaReplyVO> searchQnaReplyList(int qnaNo);       //문의게시판 댓글목록
}
