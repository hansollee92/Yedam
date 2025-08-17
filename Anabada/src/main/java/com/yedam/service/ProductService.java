package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList(ProductVO dao);

    public ProductVO searchWish (int memberNo);
	  public ProductVO findProduct(int prdNo);    //상품단건조회
	// 대표 이미지 경로 업데이트
    int updateProductImage(int prdNo, String prdImg);

    List<ProductVO> getMainRecent(int limit); // 메인 12개
    List<ProductVO> findList(Map<String,Object> param); // 목록
}
