package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.**.mapper")
public class Boot01MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot01MybatisApplication.class, args);
	}
	
	@GetMapping("/")
	public String main() {
		return "main";
	}

}
