package com.yedam.vo;

import lombok.Data;

@Data
public class ProductVO {
    private int prdNo;
    private String prdName;
    private int price;
    private String prdImg;
    private String saleStatus;
}
