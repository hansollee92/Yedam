package com.yedam.board;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;
import com.yedam.config.DataSourceConfig;
import com.yedam.config.MybatisConfig;
import com.yedam.config.RootConfig;

@SpringJUnitConfig(classes = {DataSourceConfig.class, MybatisConfig.class, RootConfig.class})
public class ReplyServiceTest {

	@Autowired ReplyService replyService;
	
	@Disabled
	@Test
	public void 등록() {
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setBno(21l);
		replyVO.setReply("댓글 테스트");
		replyVO.setReplyer("user00");
		
		int result = replyService.insert(replyVO);
		assertEquals(result, 1);
		
	}
	
	@Disabled
	@Test
	public void 전체조회() {
		List<ReplyVO> result = replyService.getList(1l);
		System.out.println(result);
	}
	
	@Disabled
	@Test
	public void 삭제() {
		int result = replyService.delete(5l);
		assertEquals(result, 1);
	}
	
}
