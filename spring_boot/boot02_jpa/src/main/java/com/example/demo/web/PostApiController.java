package com.example.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PostService;
import com.example.demo.service.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostApiController {
	
	final PostService postService;
	
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postService.save(requestDto);
	}
	
	// Entity들은 영속계층으로 DTO, VO로 사용할 수 없다.(테이블 생성하는데에 사용)
	// 그래서 따로 구분해서 만들어야한다. -> PostsSaveRequestDto
	
	
//	@GetMapping("/posts")
//	public ModelAndView posts() {
//		return new ModelAndView("posts");
//	}
	

}
