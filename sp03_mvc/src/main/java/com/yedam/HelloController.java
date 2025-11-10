package com.yedam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Component subclass 
// 기능: 1. container에 bean 등록 -> 2. 컨트롤러화(상속대신) 해줌 POJO
@Controller   
public class HelloController {
	
	@GetMapping("/")
	public String hello() {
		System.out.println("컨트롤러 동작함");
		return "hello";
	}
	// 이 헬로우를 넘기면 servlet-context.xml에서 /WEB-INF/views붙이고 뒤에 .jsp를 붙여서 해당 파일을 실행시킴
	// 에러 : org.springframework.web.context.ContextLoaderListener 가 뜨면, build path에서 설정해줘야함
	
	
	
}
