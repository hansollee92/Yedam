package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(ProductVO dao);
	
	// 대표 이미지 경로 업데이트
    int updateProductImage(int prdNo, String prdImg);

    // 대표 이미지 경로 조회
    String getProductImage(int prdNo);

    // 대표 이미지 경로 삭제 (NULL)
    int clearProductImage(int prdNo);
}
