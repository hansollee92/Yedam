package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.QnaReplyVO;

public interface QnaReplyMapper {

	public List<QnaReplyVO> selectQnaReplyList(int qnaNo);      //문의게시판 댓글 목록
	public QnaReplyVO selectQnaReply(int qnaReplyNo);           //댓글 단건 검색
	public int deleteQnaReply(int qnaReplyNo);                  //댓글 삭제 

}
