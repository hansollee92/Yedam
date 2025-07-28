package com.yedam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 생성자, getter/setter 
// lombok 라이브러리 : 1)설치 2)lib
//@Getter
//@Setter
//@NoArgsConstructor
@Data
@AllArgsConstructor
public class Book {
	
	//필드
	private int id;
	private String title;
	private String author;
	private int price;

}
