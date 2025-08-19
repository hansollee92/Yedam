package com.yedam.vo;

import lombok.Data;

@Data
public class ReviewVO {
    private int reviewNo;
    private String reviewContent;
    private Double reviewScore;
    private int memberNo;
    private int prdNo;
    private int purNo;

    // 리뷰 조회를 위한 추가 정보
    private String prdName;
    private String memberName;
}
