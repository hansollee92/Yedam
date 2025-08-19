package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.QnaReplyMapper;
import com.yedam.vo.QnaReplyVO;

public class QnaReplyServiceImpl implements QnaReplyService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    QnaReplyMapper mapper = sqlSession.getMapper(QnaReplyMapper.class);	
	
    //문의게시판 댓글 목록
	@Override
	public List<QnaReplyVO> searchQnaReplyList(int qnaNo) {
		return mapper.selectQnaReplyList(qnaNo);
	}
	
	//댓글 단검 검색
	@Override
	public QnaReplyVO searchQnaReply(int qnaReplyNo) {
		return mapper.selectQnaReply(qnaReplyNo);
	}

	//댓글 삭제
	@Override
	public boolean removeQnaReply(int qnaReplyNo) {
		int r = mapper.deleteQnaReply(qnaReplyNo);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}		
		return false;
	}


}
