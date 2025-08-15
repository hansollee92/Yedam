package com.yedam.service;

import com.yedam.vo.MemberVO;

public interface MemberService {
    public MemberVO searchMember(int memberNo);
    
    // 회원가입
    boolean registerMember(MemberVO vo);

    // 아이디 중복 여부 (있으면 true)
    boolean isDuplicateId(String memberId);
}
