package com.yedam.mapper;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
    public MemberVO selectMember(int memberNo); // 유저 정보 조회
}
