package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(ProductVO dao);
    List<ProductVO> searchWish (int memberNo); // 찜한 상품 조회
	ProductVO findProduct(int prdNo); //상품단건조회
    int updateProductImage(int prdNo, String prdImg); // 대표 이미지 경로 업데이트
    String getProductImage(int prdNo); // 대표 이미지 경로 조회
    int clearProductImage(int prdNo); // 대표 이미지 경로 삭제 (NULL)
}
