package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.QnaVO;

public interface QnaMapper {

	public List<QnaVO> selectqnaList(int prdNo);    // 문의하기 목록
}
