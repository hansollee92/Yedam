package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {

	
    public MemberVO searchMember(String memberId, String memberPw);      //로그인처리
    public MemberVO searchMember(int memberNo); // 마이페이지 회원 정보
    public boolean registerMember(MemberVO vo); // 회원가입
    public boolean isDuplicateId(String memberId); // 아이디 중복 여부 (있으면 true)


}
