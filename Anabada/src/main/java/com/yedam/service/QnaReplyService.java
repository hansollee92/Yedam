package com.yedam.service;

import java.util.List;

import com.yedam.vo.QnaReplyVO;

public interface QnaReplyService {
	
	public List<QnaReplyVO> searchQnaReplyList(int qnaNo);       //문의게시판 댓글목록
	QnaReplyVO searchQnaReply(int qnaReplyNo);                   //댓글 단건 검색
	public boolean removeQnaReply(int qnaReplyNo);               //댓글 삭제
	public boolean addQnaReply(QnaReplyVO qnaReply);             //댓글 등록
	
}
