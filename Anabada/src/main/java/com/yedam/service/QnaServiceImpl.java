package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.QnaMapper;
import com.yedam.vo.QnaVO;

public class QnaServiceImpl implements QnaService {

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
	
	// 문의게시판 목록
	@Override
	public List<QnaVO> searchQnaList(int prdNo) {
		return mapper.selectqnaList(prdNo);
	}

}
