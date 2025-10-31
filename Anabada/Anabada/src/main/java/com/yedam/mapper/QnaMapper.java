package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.QnaVO;

public interface QnaMapper {

	public List<QnaVO> selectqnaList(@Param("prdNo") int prdNo, @Param("page") int page);   // 문의하기 목록
	public QnaVO selectQna(@Param("prdNo") int prdNo, @Param("qnaNo") int qnaNo);          //문의하기 단건조회(상세)   
	public int selectCount(int prdNo);       //문의하기 전체건수(totalCnt)
	public int insertQna(QnaVO qna);         //문의하기 게시글 등록
	public int updateQna(@Param("qnaNo") int qnaNo, 
			             @Param("qnaTitle") String qnaTitle, 
			             @Param("qnaContent") String qnaContent);         //문의하기 게시글 수정
	public int deleteQna(int qnaNo);         //문의하기 게시글 삭제
	
}
