package com.yedam.common;

import lombok.Data;

// 페이징 정보
// 
@Data
public class PageDTO {
	
	//필드
	private int currPage;    //현재페이지
	private int start, end;  //시작, 끝 페이지
	
	public PageDTO(int page, int totalCnt) {
		currPage = page; // 1...3...10
		end = (int) Math.ceil(page * 1.0 / 10) * 10;  //현재페이지가 3이면 0.3이면 ceil 올림 > 1 그값에다 10을 곱하면 10!
		start = end - 9;  	
		
	}
	
	
}
