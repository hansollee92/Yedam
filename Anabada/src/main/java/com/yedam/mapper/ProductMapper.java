package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductMapper {
	List<ProductVO> productList(ProductVO dao);

    public ProductVO selectWish(int memberNo);
    public ProductVO selectProduct(int prdNo);      //상품단건조회
	// 상품 이미지 경로 업데이트
	int updateProductImage(Map<String, Object> param);

	// 상품 이미지 경로 조회
	String getProductImage(int prdNo);

	// 상품 이미지 경로 삭제
	int clearProductImage(int prdNo);

}
