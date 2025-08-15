package com.yedam.service;

import com.yedam.common.DBUtil;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;

public class MemberServiceImpl implements MemberService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();
    MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

    @Override
    public MemberVO searchMember(int memberNo) {
        return mapper.selectMember(memberNo);
    }
    
    // 아이디 중복체크
	@Override
	public boolean isDuplicateId(String memberId) {
        if (memberId == null) return false;
        int cnt = mapper.countById(memberId);
        return cnt > 0;
    }
	
	// 회원가입
	@Override
    public boolean registerMember(MemberVO vo) {
	    return mapper.insertMember(vo) == 1;
    }
}
