package com.yedam.vo;

import lombok.Data;

@Data
public class PurchaseVO {
	private int purNo;			// 구매번호 (PK)
	private int memberNo;		// 유저번호 (FK)
	private int prdNo;			// 상품번호 (FK)
}
