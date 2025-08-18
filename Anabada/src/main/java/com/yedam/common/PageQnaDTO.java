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

        int pageSize  = 5;   // 한 페이지 게시글 수
        int blockSize = 10;  // 페이지 버튼 묶음

        int realEnd = (int)Math.ceil(totalCnt / (double)pageSize);

        end = (int)Math.ceil(page / (double)blockSize) * blockSize;
        if (end > realEnd) end = realEnd;

        // end 확정 후 start 다시 계산 + 최소 1 보정
        start = end - (blockSize - 1);
        if (start < 1) start = 1;

        previous = start > 1;
        next     = end < realEnd;
		
		
//		currPage = page; 
//		end = (int) Math.ceil(page * 1.0 / 10) * 10;  
//		start = end - 9;  	
//	
//		// 실제 마지막 페이지
//		int realEnd = (int) Math.ceil(totalCnt * 1.0 / 5);
//		end = end > realEnd ? realEnd : end;
//		
//		// 이전, 이후 여부
//		previous = start > 1;
//		next = end < realEnd;
		
	}
	
}
