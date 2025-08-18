package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;
import com.yedam.vo.SearchVO;

public interface ProductService {
	  public List<ProductVO> productList();                 //상품목록
	  public ProductVO findProduct(int prdNo);              //상품(단건조회 + 조회수)
	  public boolean productModify(ProductVO product);      //상품수정 	 
	  public boolean productRemove(int prdNo);              //상품삭제
	  public boolean productSaleStatus(String saleStatus, int prdNo);  //상품 판매상태 수정
  
	  public List<ProductVO> searchWish (int memberNo);  //찜한 상품 조회  
	  public List<ProductVO> searchProducts(SearchVO s); //검색목록
	  int countProducts(SearchVO s);                     //페이징 

}	  
	  
	  
	  
	  
	  
	  
	


	
	
	
   

	
	


