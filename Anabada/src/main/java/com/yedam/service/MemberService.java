package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
	
    public MemberVO searchMember(String memberId, String memberPw);      //로그인처리
    boolean registerMember(MemberVO vo);             //회원가입 
    boolean isDuplicateId(String memberId);          //아이디 중복여부(있으면 true)
	public MemberVO searchMember(int int1);
    
}
