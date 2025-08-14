package com.yedam.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MemberVO {
    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberName;
    private Date memberBirth;
    private int memberPhone;
    private String memberImg;
    private String memberScore;

    private List<ProductVO> wish;

}
