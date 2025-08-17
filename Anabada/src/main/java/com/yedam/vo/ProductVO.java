package com.yedam.vo;

import lombok.Data;

@Data
public class ProductVO {
	private int prdNo;             //상품번호 (pk)
	private String prdName;        //상품명
	private int price;             //상품가격
	private String prdDate;        //등록일자
	private String category;       //카테고리
	private String prdStatus;      //상품상태(새제품, 고장...)
	private String prdDesc;        //상품설명
	private String prdTag;         //상품태그
	private String tradeType;      //거래방식(직거래, 택배거래)
	private String sido;           //시/도 (예:대구광역시)
	private String sigungu;        //시/군/구 (예: 수성구)
	private String dong;           //읍/면/동 (예: 범어동)
	private double lat;            //위도
	private double lng;            //경도
	private String saleStatus;     //판매상태(판매중, 예약중, 판매완료)
	private String prdImg;         //상품이미지명(상품번호_상품이름.jpg)
	private int memberNo;          //회원번호 (fk)
	private int viewCnt;           //조회수
	private String  imageUrl;	   //화면용 URL (SQL에서 alias로 내려받거나, JSP에서 조합)
}


