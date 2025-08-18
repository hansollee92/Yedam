package com.yedam.service;

import java.util.List;

import com.yedam.vo.QnaVO;

public interface QnaService {

	public List<QnaVO> searchQnaList(int prdNo);      //문의게시판 목록
	public QnaVO searchQna(int prdNo, int qnaNo);     //문의게시판 상세    
}
