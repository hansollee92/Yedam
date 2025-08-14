package com.yedam.mapper;

import com.yedam.vo.ProductVO;

public interface ProductMapper {

	public ProductVO selectProduct(int prdNo);      //상품단건조회
	
}
