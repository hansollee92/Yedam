package com.yedam.common;

import lombok.Data;

// 페이징 정보
// 
@Data
public class PageDTO {
	
	// 필드
	private int currPage;    //현재페이지
	private int start, end;  //시작, 끝 페이지
	private boolean previous, next; //이전, 이후 페이지 여부
	
	// 메소드
	public PageDTO(int page, int totalCnt) {
		currPage = page; // 1...3(기준)...10  (3을 기준으로 시작페이지1, 끝페이지 10이 페이징에 보이게 할꺼임)
		end = (int) Math.ceil(page * 1.0 / 10) * 10;  
		//현재페이지가 3이면 0.3이면 ceil 올림 > 1 그값에다 10을 곱하면 10!
		// page*1.0 --> 타입을 double 변환 
		start = end - 9;  	
	
		// 실제 마지막 페이지
		int realEnd = (int) Math.ceil(totalCnt * 1.0 / 5);
		end = end > realEnd ? realEnd : end;
		
		// 이전, 이후 여부
		previous = start > 1;
		next = end < realEnd;
		
	}
	
	
	
	
	
	
	
}
