package com.yedam.common;

import lombok.Data;

@Data
public class PageQnaDTO {

	// 필드
	private int currPage;    //현재페이지
	private int start, end;  //시작, 끝 페이지
	private boolean previous, next; //이전, 이후 페이지 여부
	
	// 메소드
	public PageQnaDTO(int page, int totalCnt) {
		currPage = page; 
		end = (int) Math.ceil(page * 1.0 / 10) * 10;  
		start = end - 9;  	
	
		// 실제 마지막 페이지
		int realEnd = (int) Math.ceil(totalCnt * 1.0 / 5);
		end = end > realEnd ? realEnd : end;
		
		// 이전, 이후 여부
		previous = start > 1;
		next = end < realEnd;
		
	}
	
}
