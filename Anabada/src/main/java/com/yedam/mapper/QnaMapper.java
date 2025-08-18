package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.QnaVO;

public interface QnaMapper {

	public List<QnaVO> selectqnaList(int prdNo);                                      // 문의하기 목록
	public QnaVO selectQna(@Param("prdNo") int prdNo, @Param("qnaNo") int qnaNo);     //문의하기 단건조회(상세)   
	
	
}
