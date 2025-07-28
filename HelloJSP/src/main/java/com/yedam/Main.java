package com.yedam;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.BoardMapper;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class Main {

	public static void main(String[] args) {
		
		BoardService svc = new BoardServiceImpl();  //업무기능
		
//		SqlSession sqlSession = DBUtil.getInstance().openSession();
//		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
//		
		// 목록
//		List<BoardVO> list = mapper.selectList();
//		for(BoardVO board : list) {
//			System.out.println(board.toString());
//		}
		
		int searchNo = 1;

		// 단건조회
		// 조회수(viewCnt) 기능 넣기		
		// -> 조회 + 조회수는 함께 
		// => 업무(조회: 글번호조회 + 조회카운트)
//		BoardVO board = mapper.selectBoard(searchNo);
//		mapper.updateCount(searchNo);
		
		BoardVO board = svc.searchBoard(searchNo);
			
		
		System.out.println(board.toString());
		

	}
	

}
