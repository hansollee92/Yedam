package com.example.demo.emp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.emp.service.EmpService;
import com.example.demo.emp.service.EmpVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/emp")
@RestController
public class EmpController {
	
	private final EmpService empService;
	
	@GetMapping("")
	public List<EmpVO> empList(EmpVO vo) {
		return empService.getEmpList(vo);
	}
}
