package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
    MemberVO searchMember(int memberNo); // 마이페이지 회원 정보
    boolean registerMember(MemberVO vo); // 회원가입
    boolean isDuplicateId(String memberId); // 아이디 중복 여부 (있으면 true)
}
