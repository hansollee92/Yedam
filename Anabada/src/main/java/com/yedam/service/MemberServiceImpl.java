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
}
