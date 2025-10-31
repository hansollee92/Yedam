package com.yedam.service;

import com.yedam.vo.ReviewVO;

import java.util.List;

public interface ReviewService {
    public List<ReviewVO> searchMyReview(int memberNo);
    public List<ReviewVO> searchOtherReview(int memberNo);
}
