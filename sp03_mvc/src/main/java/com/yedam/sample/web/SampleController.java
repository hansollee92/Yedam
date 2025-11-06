package com.yedam.sample.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@GetMapping("/success")
	public String success() {
		return "/success";
	}	
	
	// Spring MVC의 Controller 예제 중 ‘특정 URL로 들어온 요청을 처리하는’ 코드
	@RequestMapping(value={"insert", "/"}, 
			        method={RequestMethod.POST,RequestMethod.GET})
	public void basic() {
		log.info("basic....");
	}
	
	// p129-130
	// /ex01?name=aaa&age=15
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("sample") SampleDTO sample, 
			           RedirectAttributes ra) {
		log.info("sampleDTO: " + sample);
		ra.addFlashAttribute("msg", "가입축하");
		ra.addAttribute("name", sample.getName());
		// 뷰페이지로 데이터를 전달할 것을 담는 것이 모델임 
		return "redirect:/sample/success";
		
		// return "redirect:/success"; 이렇게 작성하면
		// http://localhost:81/success 바로 이렇게 들어가서 에러뜸
		// redirect 뒤에는 매핑 url을 적어줌
		// forward 뒤에는 페이지명
		
		// return "redirect:/sample/success"; 이렇게 작성(또는 return "redirect:success";)해야지
		// http://localhost:81/sample/success 이렇게 제대로 감
		
		
	}	
	
	// ex02?name=aaa&age=20 을 처리하는 방법 -> String name, int age라고 작성
	// 만약 age =   으로 null값일경우 Integer로 주면 됨
	// --> 옛날에는 public String ex02(String name, int age)라고 작성이 가능한데 지금은 이렇게 하면 Ensure that the compiler uses the '-parameters' flag. 라고 오류 뜸
	// 그래서 아래처럼 작성을 해줘야함
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, 
			           @RequestParam(value="age", 
			                         required = false, 
			                         defaultValue = "20") int age) {
		log.info(name + " : " + age);
		return "ex02";
	}
	
	// p133배열 - 동일한 이름의 파라미터가 여러개 전달되는 경우
	// ex02?ids=3&ids=4&ids=10  (예;체크박스)
	// 매개변수를 @RequestParam("ids") String[] ids 이렇게 작성하거나 @RequestParam("ids") List<String> ids 이렇게도 작성 가능
	// http://localhost:81/sample/ex02Array?ids=2&ids=4&ids=10 으로 테스트
	@GetMapping("/ex02Array")
	public void ex02Array(@RequestParam("ids") List<String> ids) {
		log.info("ids: " + ids);
	}
	
	
	@GetMapping("/ex03")
	public ModelAndView ex03(){
		ModelAndView mv = new ModelAndView("/hello", "greet", "hi");
		// mv.setViewName("/hello");
		// mv.addObject("greet", "hi");
		
		// 위의 것을 한번에 작성하는 방법은 ModelAndView mv = new ModelAndView("/hello", "greet", "hi"); 이렇게 작성하는 방법. 
		return mv;
	}
	
	
}
