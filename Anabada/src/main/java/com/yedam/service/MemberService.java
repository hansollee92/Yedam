package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
	
    public MemberVO searchMember(int memberNo);      //로그인
    boolean registerMember(MemberVO vo);             //회원가입 
    boolean isDuplicateId(String memberId);          //아이디 중복여부(있으면 true)
    
}
