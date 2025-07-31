package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public int insertMember(MemberVO member);                 //회원등록
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);       //회원조회
	// 매개변수를 이렇게 두개로 작성을 하게 되면, 파라미터를 적을 때 두개를 작성을 할 수가 없어서 
	// 위와 같이 명시를 해줘야한다. 
	

}
