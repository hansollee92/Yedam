package com.example.demo.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpController {

	@GetMapping("/empMain")
	public String page() {
		return "emp";
	}
}
