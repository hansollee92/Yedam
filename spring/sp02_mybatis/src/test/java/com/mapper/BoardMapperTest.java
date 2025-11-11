package com.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring/datasource-context.xml")
public class BoardMapperTest {
	
	@Autowired BoardMapper boardMapper;
	
	@Disabled
	@Test
	void 전체조회() {
		// -- TEST를 할 때는 아래와 같이 given, when, then으로 작성을 해주어야한다. 
		
		// given
		
		// when
		List<BoardVO> list = boardMapper.getList();
		
		// then
		assertEquals(list.get(0).getWriter(), "user01");
		
		// -- 게시글에 댓글들이 함께 보이도록 for문 sysout 돌려 출력해보기
		for(BoardVO board : list) { //게시글에
			System.out.println(board.getBno() + ": " + board.getTitle());
			for(ReplyVO reply : board.getReply()) {  //댓글 출력 
				System.out.println(reply.getReply());
			}
		}
	}
	

	@Test
	void 등록() {
		// given
		BoardVO board = new BoardVO();
		board.setContent("등록테스트");
		board.setTitle("스프링");
		board.setWriter("user03");
		
		// when
		int result = boardMapper.insert(board);
		long bno = board.getBno();
		System.out.println(bno);
		
		// then
		// 등록된 번호로 단건조회
		assertEquals(result, 1);
	}
	
	@Disabled
	@Test
	void 수정() {
		
		// given
		BoardVO board = new BoardVO();
		board.setBno((long) 1);
		board.setTitle("테스트 수정");
		board.setContent("테스트 수정중입니다.");
		
		// when
		int result = boardMapper.update(board);
		
		// then
		assertEquals(result, 1);
		
		
	}
	
	@Disabled
	@Test
	void 삭제() {
		
		// given
		// when
		int result = boardMapper.delete(3l);   // 뒤에 l붙이면 long타입
		
		// then
		assertEquals(result, 1);
		
	}
	
	
//	@Test
//	void 단건조회with댓글() {
//		
//		// given
//		BoardVO result = boardMapper.getBoard(1l);
//		
//		// when
//		// then
//		System.out.println(result);
//		for(ReplyVO reply : result.getReply()) {
//			System.out.println(reply.getReply());
//		}
//		
//	}
	
	@Disabled
	@Test
	void 검색() {
		BoardVO board = BoardVO.builder()
		                     .title("test")
		                     //.writer("user00")
		                       .build();
		List<BoardVO> list = boardMapper.getListByWriter(board);
	}
	
	
	
	
	
	
}
