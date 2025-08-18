package com.yedam.service;

import java.util.List;

import com.yedam.common.CategoryDTO;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchDTO;
import com.yedam.vo.ProductVO;

public interface ProductService {
	  public boolean productModify(ProductVO product);   //상품수정 	 
	  public ProductVO findProduct(int prdNo);       //상품(단건조회 + 조회수)
  
	  public List<ProductVO> searchWish (int memberNo); // 찜한 상품 조회
  
	  public List<ProductVO> searchProducts(SearchDTO search, CategoryDTO category);  //검색목록 / 검색결과
	  int countProducts(SearchDTO search, CategoryDTO category); //페이징
 
	  public List<ProductVO> productList();          //상품목록

}	  
	  
	  
	  
	  
	  
	  
	


	
	
	
   

	
	


