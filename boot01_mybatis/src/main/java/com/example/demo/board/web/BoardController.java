package com.example.demo.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired BoardService boardService;
	
	// 전체조회
	@GetMapping("/board")
	public String selectall(Model model) {
		model.addAttribute("list", boardService.getList());
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
		boardService.insert(board);
		return "redirect:/board";
	}
	
	// 수정페이지로 이동 
	// board/update?bno=1 / board/update/1
	@GetMapping("/board/update")    
	public String updatepage(Model model, 
			                 @RequestParam("bno") Long bno) {
		BoardVO vo = boardService.getBoard(bno);
		model.addAttribute("board", vo);
		return "board/register";
	}
	
	// 수정 처리
	@PostMapping("/board/update")
	public String update(BoardVO board) {
		boardService.update(board);
		return "redirect:/board";
	}
	
	// 삭제 처리
	@PostMapping("/board/delete")
	public String delete(Map<String, Object> map) {
		boardService.delete(map);
		return "redirect:/board";
	}
	
	
	// 단건 조회
	@GetMapping("/board/info")
	public void info(@RequestParam("bno") Long bno, 
			         Model model) {
		model.addAttribute("board", boardService.getBoard(bno));
	}
	
	
	
	
	
}
