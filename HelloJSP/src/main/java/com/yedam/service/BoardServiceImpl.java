package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

// BoardService 인터페이스 구현 클래스
// 인터페이스에 정의된 추상 메소드 반드시 구현
public class BoardServiceImpl implements BoardService {

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.selectList();   //DB - 업무(1:1매칭)
	}

	@Override
	public BoardVO searchBoard(int boardNo) {
		BoardVO board = mapper.selectBoard(boardNo);  //조회
		int r = mapper.updateCount(boardNo);  // 카운트증가
		if(r > 0) {
			sqlSession.commit();
		}
		return board;
		// 보통 이런식으로 데이터베이스를 처리하는게 여러개가 동시에 진행된다.
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		int r = mapper.insertBoard(board);
		if(r > 0) {
			sqlSession.commit();
			return true;   // 정상등록
		}
		return false; // 비정상처리
	}

	@Override
	public boolean removeBoard(int boardNo) {
		 int r = mapper.deletBoard(boardNo);
		 if(r > 0) {
			 sqlSession.commit();
			 return true;
		 }
		return false;
	}
	
	


}
