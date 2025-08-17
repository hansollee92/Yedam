package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
    public MemberVO selectMember(int memberNo);                    // 유저 정보 조회
    public int countById(@Param("memberId") String memberId);	   // 아이디 존재 개수
    public int insertMember(MemberVO vo);     					   // 회원가입 성공 시 1 반환
}
