package com.yedam.service;

import java.util.List;

import com.yedam.vo.EventVO;
import com.yedam.vo.ReplyVO;

public interface ReplyService {

	List<ReplyVO> replyList(int boardNo, int page);      //댓글목록
	boolean removeReply(int replyNo);          //댓글삭제
	boolean addReply(ReplyVO reply);           //댓글등록
	int replyCount(int boardNo);               //댓글 건수 계산
	
	// 달력 이벤트 관련
	// 목록, 추가, 삭제 -> ReplyServiceImpl에 구현
	List<EventVO> eventList();          //달력 이벤트 목록
	boolean addEvent(EventVO event);    //달력 이벤트 등록
	boolean deleteEvent(String title);  //달력 이벤트 삭제
	
}
