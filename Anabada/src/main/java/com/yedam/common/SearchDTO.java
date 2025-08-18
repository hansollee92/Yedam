package com.yedam.common;

import lombok.Data;

@Data
public class SearchDTO {
	private int page;            // 현재 페이지
    private String searchCondition;    // "N"(상품명) / "T"(태그)
    private String keyword;    //검색 키워드
    
 
}
