package com.yedam.vo;

import java.util.List;

import lombok.Data;
@Data
public class SearchVO {
	private int page = 1;              // 현재 페이지
    private int amount = 12;           // 페이지당 개수(기본 12)
    private String searchCondition;    // "N"(상품명) / "T"(태그)
    private String keyword;    
    private String category;        // 검색어

	
    public int getOffset() {           // MyBatis LIMIT에서 사용
        return (page - 1) * amount;
    }
}
