package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(ProductVO dao);
  List<ProductVO> searchWish (int memberNo); // 찜한 상품 조회
  ProductVO findProduct(int prdNo); //상품단건조회
  int updateProductImage(int prdNo, String prdImg); // 대표 이미지 경로 업데이트
  String getProductImage(int prdNo); // 대표 이미지 경로 조회
  int clearProductImage(int prdNo); // 대표 이미지 경로 삭제 (NULL)
	List<ProductVO> productList();       //상품목록
	  
	// 대표 이미지 경로 업데이트
  int updateProductImage(int prdNo, String prdImg);
  List<ProductVO> getMainRecent(int limit); // 메인 12개
  List<ProductVO> findList(Map<String,Object> param); // 목록
}
