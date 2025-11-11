package com.yedam.board.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.board.service.BoardVO;

@Mapper
public interface BoardMapper {
	
	// 등록
	int insert(BoardVO board);
	
	// 수정
	int update(BoardVO board);
	
	// 삭제
	int delete(Map<String, Object> map);
	
	// 단건조회 
	BoardVO getBoard(Long bno);
	
	// 전체조회 (p185)
	List<BoardVO> getList();
	
	// 전체조회(for 검색)
	List<BoardVO> getListByWriter(BoardVO board);  
	
	// 페이징 - 전체건수조회
	int count();
	
}

