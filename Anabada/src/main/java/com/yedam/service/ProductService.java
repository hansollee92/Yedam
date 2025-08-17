package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ProductVO;

public interface ProductService {

	
	public List<ProductVO> productList();          //상품목록
	public ProductVO findProduct(int prdNo);       //상품(단건조회 + 조회수)
  public boolean productModify(ProductVO product);   //상품수정 	  

	public List<ProductVO> productList(ProductVO dao);
	public List<ProductVO> searchWish (int memberNo); // 찜한 상품 조회
	


}
