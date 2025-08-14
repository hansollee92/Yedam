package com.yedam.vo;

import lombok.Data;

@Data
public class memberVO {
	
	private int memberNo;          //유저번호(회원번호)
	private String memberId;       //아이디
	private String memberPw;       //비밀번호
	private String memberName;     //이름
	private String memberBirth;    //생년월일
	private int memberPhone;       //전화번호
	private String memberImg;      //멤버이미지(default null 들어갈 수 있게 할 수 있나?)
	private int memberScore;       //평점
	
}

