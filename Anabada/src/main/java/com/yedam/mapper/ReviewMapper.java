package com.yedam.mapper;

import com.yedam.vo.ReviewVO;

import java.util.List;

public interface ReviewMapper {
    public List<ReviewVO> selectMyReview(int memberNo); // 내가 쓴 리뷰
    public List<ReviewVO> selectOtherReview(int memberNo); // 내가 받은 리뷰
}
