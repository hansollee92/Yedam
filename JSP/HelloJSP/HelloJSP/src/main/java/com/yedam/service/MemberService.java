package com.yedam.service;

import com.yedam.vo.MemberVO;

// 회원관련 업무
public interface MemberService {
	public boolean addMember(MemberVO member);          //회원등록
	public MemberVO userCheck(String id, String pw);    //회원확인(조회)
}
