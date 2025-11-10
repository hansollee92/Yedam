package com.yedam.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class MemberController {

	// 회원가입페이지 
	@GetMapping("/member")
	public void memberForm(Member member) {}
	
	// 회원가입 처리
	@PostMapping("/member")
	public String memberRegister(@Valid Member member,
			                     BindingResult result) {
		
		if(result.hasErrors()) {
			return "/member";
		}else {
			log.info(member);
			return "redirect:/";			
		}
		
	}
	
}
