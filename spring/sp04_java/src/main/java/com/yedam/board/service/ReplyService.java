package com.yedam.board.service;

import java.util.List;

public interface ReplyService {

	// 전체조회
	List<ReplyVO> getList(Long bno);
	
	// 등록
	int insert(ReplyVO reply);
	
	// 삭제 
	int delete(Long rno);
	
}
