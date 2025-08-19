package com.yedam.service;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ReviewMapper;
import com.yedam.vo.ReviewVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    SqlSession sqlSession = DBUtil.getInstance().openSession();

    ReviewMapper mapper = sqlSession.getMapper(ReviewMapper.class);

    @Override
    public List<ReviewVO> searchMyReview(int memberNo) {
        return mapper.selectMyReview(memberNo);
    }

    @Override
    public List<ReviewVO> searchOtherReview(int memberNo) {
        return mapper.selectOtherReview(memberNo);
    }
}
