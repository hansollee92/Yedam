package com.yedam.board.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.ReplyService;
import com.yedam.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ReplyController {
	
	private final ReplyService replyService;
	
	// 등록
	// localhost/reply
	@PostMapping("/reply")        
	public int insert(@RequestBody ReplyVO vo) {
		return replyService.insert(vo);
		// {result: "success", date: ""} <- 보통은 등록의 경우 리턴을 이런 형태로 전달함
	}
	//@RequestBody라고 되어있어야지 JSON 형태이고 아니면 그냥 쿼리스트링으로 데이터값 보내야함
	
	
	// 삭제
	// localhost/reply/10
	@DeleteMapping("/reply/{rno}")
	public int delete(@PathVariable("rno") Long rno) {
		return replyService.delete(rno);
	}
	// 그냥 delete(Long rno)라고 적으면 안됨.
	// “URL 경로에서 값 꺼내야 한다”는 걸 스프링이 알아야 하니까 @PathVariable 이 꼭 필요함
	
	
	// 전체조회
	// localhost:81/board/1/reply
	@GetMapping("/board/{bno}/reply")
	public List<ReplyVO> select(@PathVariable("bno") Long bno){
		return replyService.getList(bno);
	}

}
