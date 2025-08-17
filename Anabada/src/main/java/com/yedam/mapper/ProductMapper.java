package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductMapper {
	List<ProductVO> productList(ProductVO dao);
    List<ProductVO> selectWish(int memberNo); // 내가 찜한 상품 조회
    ProductVO selectProduct(int prdNo); //상품단건조회
	int updateProductImage(Map<String, Object> param); // 상품 이미지 경로 업데이트
	String getProductImage(int prdNo); // 상품 이미지 경로 조회
	int clearProductImage(int prdNo); // 상품 이미지 경로 삭제

}
