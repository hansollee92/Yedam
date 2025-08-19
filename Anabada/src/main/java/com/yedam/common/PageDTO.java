package com.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int currPage; // 현재 페이지.
	private int start, end; // 시작, 끝페이지.
	private boolean previous, next; //이전, 이후 여부
	
	public PageDTO(int page, int totalCnt) {
		// [변경] 안전 보정(최소 1페이지)
        currPage = Math.max(1, page);

        // [추가] pageSize=12, blockSize=10 으로 분리
        int pageSize = 12;
        int blockSize = 10;

        // [변경] 블록 계산을 blockSize 기반으로
        end = (int) Math.ceil(currPage * 1.0 / blockSize) * blockSize;
        start = end - (blockSize - 1);
        if (start < 1) start = 1; // [추가] 시작 하한 보정

        // [변경] 실제 마지막 페이지는 pageSize(=12) 기준
        int realEnd = (int) Math.ceil(totalCnt * 1.0 / pageSize);
        if (realEnd <= 0) realEnd = 1; // [추가] 0건일 때도 UI 안정성 유지

        // [유지+보강] end 상한 보정
        end = end > realEnd ? realEnd : end;

        // [유지] 이전, 이후
        previous = start > 1 ? true : false;
        next = end < realEnd;
	}	
}
