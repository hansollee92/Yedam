package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ProductVO {
	private int prdNo;          // 상품번호 (PK)
    private String prdName;     // 상품명
    private long price;         // 상품가격
    private Date prdDate;       // 등록일자
    private String category;    // 카테고리
    private String prdStatus;   // 상품상태 (새것, 사용감있음 등등..)
    private String prdDesc;     // 상품설명
    private String prdTag;      // 태그
    private String tradeType;   // 거래방식
    private String field;       // 지역
    private String saleStatus;  // 판매상태 (판매완, 판매중, 예약중 등등..)
    private String prdImg;      // 상품이미지명
    private int memberNo;       // 유저번호 (FK)
}
