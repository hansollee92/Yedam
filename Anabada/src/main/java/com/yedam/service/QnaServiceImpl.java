package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.QnaMapper;
import com.yedam.vo.QnaVO;

public class QnaServiceImpl implements QnaService {

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
	
	// 문의게시판 목록(다건)
	@Override
	public List<QnaVO> searchQnaList(int prdNo, int page) {
		return mapper.selectqnaList(prdNo, page);
	}

	// 문의게시판 상세(단건)
	@Override
	public QnaVO searchQna(int prdNo, int qnaNo) {
		return mapper.selectQna(prdNo, qnaNo);
	}

	//문의게시판 전체건수(totalCnt)
	@Override
	public int totalCnt(int prdNo) {
		return mapper.selectCount(prdNo);
	}

	//문의게시판 글등록
	@Override
	public boolean qnaResigter(QnaVO qna) {
		int r = mapper.insertQna(qna);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}		
		return false;
	}

}
