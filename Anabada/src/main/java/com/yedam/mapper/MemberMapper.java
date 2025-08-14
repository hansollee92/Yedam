package com.yedam.mapper;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	int existsMemberId(String memberId);  // 회원가입 시 아이디가 중복이면 1이상 반환
    int insertMember(MemberVO vo);        // 회원가입 성공 시 1 반환
}