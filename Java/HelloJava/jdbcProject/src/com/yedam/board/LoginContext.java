package com.yedam.board;

public class LoginContext {
	// 로그인 유저 정보를 저장하기 위한 loginUser 변수선언(데이터타입은 Member이며 초기값은 null)
	// 전역 사용을 위해 public, 객체 생성 없이 바로 사용할수있게 static 
	public static Member loginUser = null;
}
