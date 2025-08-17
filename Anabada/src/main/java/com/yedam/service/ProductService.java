package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(ProductVO dao);
	public List<ProductVO> searchWish (int memberNo); // 찜한 상품 조회
	
	public ProductVO findProduct(int prdNo); //상품단건조회
	public List<ProductVO> productList();       //상품목록
	
	
	// 한솔이가 확인하고 아래 주석풀고 사용할지 말지 결정
	
	// 대표 이미지 경로 업데이트
	// List<ProductVO> getMainRecent(int limit); // 메인 12개
	// List<ProductVO> findList(Map<String,Object> param); // 목록
	// int updateProductImage(int prdNo, String prdImg); // 대표 이미지 경로 업데이트
	// String getProductImage(int prdNo); // 대표 이미지 경로 조회
	// int clearProductImage(int prdNo); // 대표 이미지 경로 삭제 (NULL)
}
