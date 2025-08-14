package com.yedam.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private int memberNo;			// 유저번호 (PK)
	private String memberId;		// 아이디
	private String memberPw;		// 비밀번호
	private String memberName;		// 이름
	private Date memberBirth;		// 생년월일
	private String memberPhone;		// 전화번호( - 생략 안내 해야됨, String 아니라서)
	private String memberImg;		// 이미지파일 이름
	private int memberScore;		// 평점(별점)
}