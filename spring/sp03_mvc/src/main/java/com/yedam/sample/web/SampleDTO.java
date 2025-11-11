package com.yedam.sample.web;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class SampleDTO {
	private String name;
	private Integer age;     //null값 허용하니 Integer
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	//private MultipartFile profile;
}
