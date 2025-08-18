package com.yedam.service;

import java.util.List;

import com.yedam.vo.QnaVO;

public interface QnaService {

	public List<QnaVO> searchQnaList(int prdNo);      //문의게시판
}
