package com.yedam.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.CommuVO;

public interface CommuMapper {

	public List<CommuVO> selectCommu(int commuNo);             // 전체 조회  
	public CommuVO selectCommuOne(int commuNo);                // 단건 조회
	public int insertCommu(CommuVO vo);                        // 등록
	public int updateCommu(CommuVO vo);                        // 수정
	public int deleteCommu(@Param("commuNo") int commuNo);     // 삭제
	
}



