package com.yedam.service;

import java.util.List;

import com.yedam.vo.QnaVO;

public interface QnaService {

	public List<QnaVO> searchQnaList(int prdNo, int page);      //문의게시판 목록
	public QnaVO searchQna(int prdNo, int qnaNo);               //문의게시판 상세    
	public int totalCnt(int prdNo);                             //문의게시판 전체건수
	public boolean qnaResigter(QnaVO qna);                      //문의게시판 글등록
}
