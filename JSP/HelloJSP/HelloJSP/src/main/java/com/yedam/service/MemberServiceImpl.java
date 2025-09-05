package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	// 회원등록
	@Override
	public boolean addMember(MemberVO member) {
		int r = mapper.insertMember(member);
		if(r > 0) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	// 회원확인(조회)
	@Override
	public MemberVO userCheck(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
	
	

}
