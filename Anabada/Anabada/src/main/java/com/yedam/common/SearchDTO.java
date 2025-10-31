package com.yedam.common;

import lombok.Data;

@Data
public class SearchDTO {
	private int page;            // 현재 페이지
    private String searchCondition;    // "N"(상품명) / "T"(태그)
    private String keyword;    //검색 키워드
    private String category;
    
    private String sido;     // 시/도
    private String sigungu;  // 시/군/구
    private String dong;     // 읍/면/동
    
    private String sort; //latest / price_asc / price_desc


   
    
 
}
