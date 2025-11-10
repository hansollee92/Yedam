package com.yedam.board.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.board.BoardVO;
import com.yedam.board.mapper.BoardMapper;

@Controller
public class BoardController {
	
	
	@Autowired BoardMapper boardMapper;
	
	// 전체조회
	@GetMapping("/board")
	public String selectall(Model model) {
		model.addAttribute("list", boardMapper.getList());
		return "board/list";
	}
	
	// 등록페이지로 이동
	@GetMapping("/board/register")
	public String registerpage() {
		return "board/register";
	}
	
	// 등록처리
	@PostMapping("/board/register")
	public String register(BoardVO board) {
		boardMapper.insert(board);
		return "redirect:/board";
	}
	
	// 수정페이지로 이동 
	// board/update?bno=1 / board/update/1
	@GetMapping("/board/update")    
	public String updatepage(Model model, 
			                 @RequestParam("bno") Long bno) {
		BoardVO vo = boardMapper.getBoard(bno);
		model.addAttribute("board", vo);
		return "board/register";
	}
	
	// 수정 처리
	@PostMapping("/board/update")
	public String update(BoardVO board) {
		boardMapper.update(board);
		return "redirect:/board";
	}
	
	// 삭제 처리
	@PostMapping("/board/delete")
	public String delete(Map<String, Object> map) {
		boardMapper.delete(map);
		return "redirect:/board";
	}
	
}
