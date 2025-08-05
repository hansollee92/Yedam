package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{

	SqlSession sqlSession = DBUtil.getInstance().openSession();     //DB연결
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);   //mapper연결
	
	@Override
	public List<ReplyVO> replyList(int boardNo) {
			
		return mapper.replyList(boardNo);   //select이름으로해야하는데.... 
	}

}