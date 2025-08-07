package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.EventVO;
import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	
	List<ReplyVO> replyList(@Param("boardNo") int boardNo, @Param("page")int page);   //댓글 목록
	int deleteReply(int replyNo);           //댓글 삭제
	int insertReply(ReplyVO reply);         //댓글 등록
	int selectCount(int boardNo);           //댓글 건수 계산
	
	// Calender 목록, 추가, 삭제 -> mapper.xml에 추가 
	List<EventVO> eventList();         //달력 이벤트 목록
	int insertEvent(EventVO event);    //달력 이벤트 등록
	int deleteEvent(String title);     //달력 이벤트 삭제
}
