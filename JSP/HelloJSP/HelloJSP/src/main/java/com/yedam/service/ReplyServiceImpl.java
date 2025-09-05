package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.EventVO;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{

	SqlSession sqlSession = DBUtil.getInstance().openSession();     //DB연결
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);   //mapper연결
	
	@Override
	public List<ReplyVO> replyList(int boardNo, int page) {
		return mapper.replyList(boardNo, page);   //select이름으로해야하는데.... 
	}

	@Override
	public boolean removeReply(int replyNo) {
		
		int r = mapper.deleteReply(replyNo);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}		
		return false;
	}

	@Override
	public boolean addReply(ReplyVO reply) {
		int r = mapper.insertReply(reply);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}		
		return false;
	}
	
	@Override
	public int replyCount(int boardNo) {
		return mapper.selectCount(boardNo);
	}
	
	
	
	
	
	
	
	
	
	// 달력 이벤트
	
	@Override
	public List<EventVO> eventList() {
		return mapper.eventList();
	}
	
	@Override
	public boolean addEvent(EventVO event) {
		int r = mapper.insertEvent(event);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEvent(String title) {
		int r = mapper.deleteEvent(title);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}		
		return false;
	}




	

}