package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	// 해당글에 해당하는 댓글 전체조회
	List<ReplyVO> getList(Long bno);
	
	// 등록
	int insert(ReplyVO reply);
	
	// 삭제 
	int delete(Long rno);
}
